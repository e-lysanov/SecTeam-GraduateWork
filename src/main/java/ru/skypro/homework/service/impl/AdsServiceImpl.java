package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.service.AdsService;

/**
 * Реализация сервиса для объявлений
 */
@Service
public class AdsServiceImpl implements AdsService {

    /**
     * Получение всех объявлений
     * @return
     */
    @Override
    public AdsDTO getAds() {
        return null;
    }

    /**
     * Добавление объявления
     * @param adDTO
     * @param image
     * @return
     */
    @Override
    public AdDTO addAd(AdDTO adDTO, MultipartFile image) {
        return null;
    }

    /**
     * Получение информации об объявлении
     * @param id
     * @return
     */
    @Override
    public ExtendedAdDTO getAd(int id) {
        return null;
    }

    /**
     * Удаление объявления
     * @param id
     */
    @Override
    public void deleteAd(int id) {

    }

    /**
     * Обновление информации об объявлении
     * @param id
     * @param createOrUpdateAd
     * @return
     */
    @Override
    public AdDTO updateAd(int id, CreateOrUpdateAdDTO createOrUpdateAd) {
        return null;
    }

    /**
     * Получение объявлений авторизованного пользователя
     * @return
     */
    @Override
    public AdsDTO getMyAds() {
        return null;
    }

    /**
     * Обновление картинки объявления
     * @param id
     * @param image
     * @return
     */
    @Override
    public AdDTO updateAvatar(int id, MultipartFile image) {
        return null;
    }
}
