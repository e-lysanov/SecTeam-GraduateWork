package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.mappers.AdMapper;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Реализация сервиса для объявлений
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdsServiceImpl implements AdsService {
    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final AdMapper adMapper;
    private final ImageService imageService;

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
            adsDTO.add(adDTO);
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
     * @param authentication
     * @return
     */
    @Override
    public AdDTO addAd(CreateOrUpdateAdDTO createAdDTO, MultipartFile image,
                       Authentication authentication) throws IOException {
        User author = userRepository.findByEmail(authentication.getName());
        Ad ad = adMapper.createToModel(createAdDTO);
        adRepository.save(ad);
        Image uploadedImage = imageService.uploadAdImage(ad.getPk(), image);
        ad.setAuthor(author);
        ad.setImage(uploadedImage.getFilePath());
        adRepository.save(ad);
        log.info("Метод добавления объявления выполнен");
        return adMapper.toDto(ad, author);
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
        Image deletedImage = imageRepository.findByAdPk(id).orElse(null);
        if (deletedImage != null) {
            imageRepository.deleteById(deletedImage.getId());
        } else {
            adRepository.deleteById(id);
        }
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
        Ad ad = adRepository.findByPk(id);
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
    public AdsDTO getMyAds(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        List<Ad> myAds = adRepository.findAllByAuthorId(user.getId());
        List<AdDTO> adsDTO = new ArrayList<>();
        AdsDTO adsDTOs = new AdsDTO(1, null);
        for (Ad ad : myAds) {
            AdDTO adDTO = adMapper.toDto(ad, ad.getAuthor());
            adsDTO.add(adDTO);
        }
        adsDTOs.setCount(adsDTO.size());
        adsDTOs.setResults(adsDTO);
        log.info("Метод получения объявлений авторизованного пользователя выполнен");
        return adsDTOs;
    }

    /**
     * Обновление картинки объявления
     *
     * @param id
     * @param image
     * @return
     */
    @Override
    public byte[] updateImage(long id, MultipartFile image) throws IOException {
        Ad ad = adRepository.findByPk(id);
        ad.setImage(null);
        imageService.uploadAdImage(id, image);
        ad.setImage(imageRepository.findByAdPk(id).orElse(null).getFilePath());
        adRepository.save(ad);
        log.info("Метод обновления картинки объявления выполнен");
        return imageRepository.findByAdPk(id).get().getData();
    }
}
