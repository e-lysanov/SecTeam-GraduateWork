package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Класс для работы с картинками.
 * Имеет поле директории для сохранения картинок
 * 2 основных метода для сохранения картинок объявлений и пользователей
 * Остальные методы вспомогательные
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {
    private final AdRepository adRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    @Value("${path.to.adImages.folder}")
    private String adImageDir;

    @Value("${path.to.avatars.folder}")
    private String avatars;

    /**
     * Добавление картинки для объявления
     * @param adId
     * @param image
     * @return
     * @throws IOException
     */
    @Override
    public Image uploadAdImage(long adId, MultipartFile image) throws IOException {
        Ad ad = adRepository.findByPk(adId);
        Path filePath = Path.of(adImageDir,ad.getPk() + "." + getExtensions(image.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = image.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        Image imageAd = findImage(ad.getPk());
        imageAd.setAd(ad);
        imageAd.setFilePath(filePath.toString());
        imageAd.setFileSize(image.getSize());
        imageAd.setMediaType(image.getContentType());
        imageAd.setData(generateDataForDB(filePath));
        imageRepository.save(imageAd);
        log.info("Картинка объявления загружена" + imageAd);
        return imageAd;
    }

    /**
     * Добавление аватара пользователю
     * @param image
     * @param authentication
     * @return
     * @throws IOException
     */
    @Override
    public Image uploadUserAvatar(MultipartFile image, Authentication authentication) throws IOException {
        User user = userRepository.findByEmail(authentication.getName());
        Path filePath = Path.of(avatars,user.getId() + "." + getExtensions(image.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = image.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        Image imageUser = findImage(user.getId());
        imageUser.setUser(user);
        imageUser.setFilePath(filePath.toString());
        imageUser.setFileSize(image.getSize());
        imageUser.setMediaType(image.getContentType());
        imageUser.setData(generateDataForDB(filePath));
        imageRepository.save(imageUser);
        log.info("Аватар пользователя загружен" + imageUser);
        return imageUser;
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    @Override
    public Image findImage(long id) {
        return imageRepository.findByAdPk(id).orElse(new Image());
    }

    private byte[] generateDataForDB(Path filePath) throws IOException {
        try (
                InputStream is = Files.newInputStream(filePath);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage image = ImageIO.read(bis);

            int height = image.getHeight() / (image.getWidth() / 100);
            BufferedImage preview = new BufferedImage(100, height, image.getType());
            Graphics2D graphics2D = preview.createGraphics();
            graphics2D.drawImage(image, 0, 0, 100, height, null);
            graphics2D.dispose();

            ImageIO.write(preview, getExtensions(filePath.getFileName().toString()), baos);
            return baos.toByteArray();
        }
    }
}
