package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.mappers.AdMapper;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Реализация сервиса для объявлений
 */
@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {
    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final AdMapper adMapper;

    /**
     * Получение всех объявлений
     *
     * @return
     */
    @Override
    public AdsDTO getAds() {
        List<Ad> ads = adRepository.findAll();
        List<AdDTO> adsDTO = new ArrayList<>();
        for (Ad ad : ads) {
            AdDTO adDTO = adMapper.toDto(ad, ad.getAuthor());
            adsDTO.add(adDTO);
        }
        return new AdsDTO(adsDTO.size(), adsDTO);
    }

    /**
     * Добавление объявления
     *
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
     *
     * @param id
     * @return
     */
    @Override
    public ExtendedAdDTO getAd(int id) {
        return null;
    }

    /**
     * Удаление объявления
     *
     * @param id
     */
    @Override
    public void deleteAd(int id) {

    }

    /**
     * Обновление информации об объявлении
     *
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
    public AdDTO updateAvatar(int id, MultipartFile image) {
        return null;
    }
}
