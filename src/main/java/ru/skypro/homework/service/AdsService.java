package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.Ad;
import ru.skypro.homework.dto.ads.Ads;
import ru.skypro.homework.dto.ads.CreateOrUpdateAd;
import ru.skypro.homework.dto.ads.ExtendedAd;
import ru.skypro.homework.dto.users.User;

public interface AdsService {
    Ads getAds();

    Ad addAd(CreateOrUpdateAd createOrUpdateAd, MultipartFile image);

    ExtendedAd getAd(int id);

    void deleteAd(int id);

    Ad updateAd(int id, CreateOrUpdateAd createOrUpdateAd);

    Ads getMyAds();

    Ad updateAvatar(int id, MultipartFile image);
}
