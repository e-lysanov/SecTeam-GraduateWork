package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.service.AdsService;

import java.util.List;

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
        log.info("Эндпоинт получения всех объявлений выполнен");
        return adsService.getAds();
    }

    /**
     * Добавление объявления
     * @param adDTO
     * @param image
     * @return
     */
    @PostMapping
    public Ad addAd(@RequestBody AdDTO adDTO, @RequestBody MultipartFile image) {
        log.info("Эндпоинт добавления нового объявления выполнен");
       return adsService.addAd(adDTO, image);
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
    public ResponseEntity<?> deleteAd(@RequestParam int id) {
        adsService.deleteAd(id);
        return ResponseEntity.ok().build();
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
    public ResponseEntity<String> updateAvatar(@RequestParam int id, @RequestBody MultipartFile image) {
        adsService.updateAvatar(id, image);
        return ResponseEntity.ok(image.toString());
    }

    }
