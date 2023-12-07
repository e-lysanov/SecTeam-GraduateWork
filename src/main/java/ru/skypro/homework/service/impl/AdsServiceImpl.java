package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.mappers.AdMapper;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;


/**
 * Реализация сервиса для объявлений
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdsServiceImpl implements AdsService {
    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final AdMapper adMapper;
    private final UserMapper userMapper;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    /**
     * Получение всех объявлений
     *
     * @return
     */
    @Override
    public AdsDTO getAds() {
        List<Ad> ads = adRepository.findAll();
        List<AdDTO> adsDTO = new ArrayList<>();
        AdsDTO adsDTOs = new AdsDTO(1, null);
        for (Ad ad : ads) {
            AdDTO adDTO = adMapper.toDto(ad, ad.getAuthor());
            AdDTO adDTOElement = new AdDTO();
            adDTOElement.setImage(adDTO.getImage());
            adDTOElement.setPk(adDTO.getPk());
            adDTOElement.setAuthor(adDTO.getAuthor());
            adDTOElement.setTitle(adDTO.getTitle());
            adDTOElement.setPrice(adDTO.getPrice());
            adsDTO.add(adDTOElement);
        }
        adsDTOs.setCount(adsDTO.size());
        adsDTOs.setResults(adsDTO);
        log.info("Метод получения всех объявлений выполнен");
        return adsDTOs;
    }

    /**
     * Добавление объявления
     *
     * @param createAdDTO
     * @param image
     * @return
     */
    @Override
    public AdDTO addAd(CreateOrUpdateAdDTO createAdDTO, MultipartFile image) {
// ----- необходимо получить автора объявления

//        Ad ad = adMapper.toModel(createAdDTO, createAdDTO.getAuthor());
//
//        AdDTO newAd = adMapper.toDto(createAdDTO, userDTO);
//        adRepository.save(ad);
        log.info("Метод добавления объявления выполнен");
        return null;
    }

    /**
     * Получение информации об объявлении
     *
     * @param id
     * @return
     */
    @Override
    public ExtendedAdDTO getAd(long id) {
        Ad ad = adRepository.findById(id).orElse(null);
        User user = ad.getAuthor();
        ExtendedAdDTO extendedAdDTO = adMapper.toExtendedDTO(ad, user);
        log.info("Метод получения информации об объявлении выполнен");
        return extendedAdDTO;
    }

    /**
     * Удаление объявления
     *
     * @param id
     */
    @Override
    public void deleteAd(long id) {
        adRepository.deleteById(id);
        log.info("Метод удаления объявления выполнен");
    }

    /**
     * Обновление информации об объявлении
     *
     * @param id
     * @param createOrUpdateAd
     * @return
     */
    @Override
    public AdDTO updateAd(long id, CreateOrUpdateAdDTO createOrUpdateAd) {
        Ad ad = adRepository.findById(id).orElse(null);
        if (ad == null) {
            return null;
        }
        ad.setPrice(createOrUpdateAd.getPrice());
        ad.setTitle(createOrUpdateAd.getTitle());
        ad.setDescription(createOrUpdateAd.getDescription());
        AdDTO adDTO = adMapper.toDto(ad, ad.getAuthor());
        adRepository.save(ad);
        log.info("Метод обновления объявления выполнен");
        return adDTO;
    }

    /**
     * Получение объявлений авторизованного пользователя
     *
     * @return
     */
    @Override
    public AdsDTO getMyAds() {
        return null;
    }

    /**
     * Обновление картинки объявления
     *
     * @param id
     * @param image
     * @return
     */
    @Override
    public String updateAvatar(long id, MultipartFile image) throws IOException {
        Ad ad = adRepository.findById(id).orElse(null);
        Path filePath = Path.of(avatarsDir, ad + "." + getExtensions(image.getOriginalFilename()));
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
        // ----- Необходимо создать модель изображений (Image). Ниже примеры из прошлой работы
//        Image adImage = findAvatar(studentId);
//        adImage.setStudent(student);
//        adImage.setFilePath(filePath.toString());
//        adImage.setFileSize(avatarFile.getSize());
//        adImage.setMediaType(avatarFile.getContentType());
//        adImage.setData(generateDataForDB(filePath));
//        imageRepository.save(adImage);
        log.info("Метод обновления картинки объявления выполнен");
        return ad.getImage();
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
