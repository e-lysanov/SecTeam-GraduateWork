package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.service.AdsService;

/**
 * Контроллер для эндпоинтов объявлений.
 */
@Slf4j
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;

    /**
     * Получение всех объявлений
     * @return
     */
    @GetMapping
    public AdsDTO getAds() {
        return adsService.getAds();
    }

    /**
     * Добавление объявления
     * @param createOrUpdateAd
     * @param image
     * @return
     */
    @PostMapping
    public AdDTO addAd(@RequestBody CreateOrUpdateAdDTO createOrUpdateAd, @RequestBody MultipartFile image) {
        return adsService.addAd(createOrUpdateAd, image);
    }

    /**
     * Получение информации об объявлении
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ExtendedAdDTO getInfoAd(@RequestParam int id) {
        return adsService.getAd(id);
    }

    /**
     * Удаление объявления
     * @param id
     */
    @DeleteMapping("{id}")
    public void deleteAd(@RequestParam int id) {
        adsService.deleteAd(id);
    }

    /**
     * Обновление информации об объявлении
     * @param id
     * @param createOrUpdateAd
     * @return
     */
    @PatchMapping("{id}")
    public AdDTO updateAd(@RequestParam int id, @RequestBody CreateOrUpdateAdDTO createOrUpdateAd) {
        return adsService.updateAd(id, createOrUpdateAd);
    }

    /**
     * Получение объявлений авторизованного пользователя
     * @return
     */
    @GetMapping("/me")
    public AdsDTO getMyAds() {
        return adsService.getMyAds();
    }

    /**
     * Обновление картинки объявления
     * @param id
     * @param image
     * @return
     */
    @PatchMapping("/{id}/image")
    public AdDTO updateAvatar(@RequestParam int id, @RequestBody MultipartFile image) {
        return adsService.updateAvatar(id, image);
    }

    }
