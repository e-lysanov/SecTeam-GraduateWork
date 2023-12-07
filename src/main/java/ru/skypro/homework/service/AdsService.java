package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.model.Ad;

public interface AdsService {
    AdsDTO getAds();

    AdDTO addAd(CreateOrUpdateAdDTO createAdDTO, MultipartFile image);

    ExtendedAdDTO getAd(long id);

    void deleteAd(long id);

    AdDTO updateAd(long id, CreateOrUpdateAdDTO createOrUpdateAd);

    AdsDTO getMyAds();

    AdDTO updateAvatar(long id, MultipartFile image);
}
