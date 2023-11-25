package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;

public interface AdsService {
    AdsDTO getAds();

    AdDTO addAd(AdDTO adDTO, MultipartFile image);

    ExtendedAdDTO getAd(int id);

    void deleteAd(int id);

    AdDTO updateAd(int id, CreateOrUpdateAdDTO createOrUpdateAd);

    AdsDTO getMyAds();

    AdDTO updateAvatar(int id, MultipartFile image);
}
