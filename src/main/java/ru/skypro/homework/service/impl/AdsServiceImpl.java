package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.Ad;
import ru.skypro.homework.dto.ads.Ads;
import ru.skypro.homework.dto.ads.CreateOrUpdateAd;
import ru.skypro.homework.dto.ads.ExtendedAd;
import ru.skypro.homework.service.AdsService;
@Service
public class AdsServiceImpl implements AdsService {
    @Override
    public Ads getAds() {
        return null;
    }

    @Override
    public Ad addAd(CreateOrUpdateAd createOrUpdateAd, MultipartFile image) {
        return null;
    }

    @Override
    public ExtendedAd getAd(int id) {
        return null;
    }

    @Override
    public void deleteAd(int id) {

    }

    @Override
    public Ad updateAd(int id, CreateOrUpdateAd createOrUpdateAd) {
        return null;
    }

    @Override
    public Ads getMyAds() {
        return null;
    }

    @Override
    public Ad updateAvatar(int id, MultipartFile image) {
        return null;
    }
}
