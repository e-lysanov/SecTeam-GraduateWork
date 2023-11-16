package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.Ad;
import ru.skypro.homework.dto.ads.Ads;
import ru.skypro.homework.dto.ads.CreateOrUpdateAd;
import ru.skypro.homework.dto.ads.ExtendedAd;
import ru.skypro.homework.service.AdsService;

@Slf4j
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;

    @GetMapping
    public Ads getAds() {
        return adsService.getAds();
    }

    @PostMapping
    public Ad addAd(@RequestBody CreateOrUpdateAd createOrUpdateAd, @RequestBody MultipartFile image) {
        return adsService.addAd(createOrUpdateAd, image);
    }

    @GetMapping("id")
    public ExtendedAd getInfoAd(@RequestParam int id) {
        return adsService.getAd(id);
    }

    @DeleteMapping("id")
    public void deleteAd(@RequestParam int id) {
        adsService.deleteAd(id);
    }

    @PatchMapping("id")
    public Ad updateAd(@RequestParam int id, @RequestBody CreateOrUpdateAd createOrUpdateAd) {
        return adsService.updateAd(id, createOrUpdateAd);
    }

    @GetMapping("/me")
    public Ads getMyAds() {
        return adsService.getMyAds();
    }

    @PatchMapping("/{id}/image")
    public Ad updateAvatar(@RequestParam int id, @RequestBody MultipartFile image) {
        return adsService.updateAvatar(id, image);
    }

    }
