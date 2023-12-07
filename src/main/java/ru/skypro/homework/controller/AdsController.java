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

import java.io.IOException;
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
     * @param createAdDTO
     * @param image
     * @return
     */
    @PostMapping
    public AdDTO addAd(@RequestBody CreateOrUpdateAdDTO createAdDTO, @RequestBody MultipartFile image) {
        log.info("Эндпоинт добавления нового объявления выполнен");
       return adsService.addAd(createAdDTO, image);
    }

    /**
     * Получение информации об объявлении
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ExtendedAdDTO getInfoAd(@RequestParam int id) {
        log.info("Эндпоинт получения информации об объявлении выполнен");
        return adsService.getAd(id);
    }

    /**
     * Удаление объявления
     * @param id
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAd(@RequestParam int id) {
        adsService.deleteAd(id);
        log.info("Эндпоинт удаления объявления выполнен");
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
        log.info("Эндпоинт обновления объявления выполнен");
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
    public ResponseEntity<String> updateAvatar(@RequestParam int id, @RequestBody MultipartFile image) throws IOException {
        adsService.updateAvatar(id, image);
        log.info("Эндпоинт обновления картинки объявления выполнен");
//        return ResponseEntity.ok(image.toString()); --- вернуть, когда настроим сохранение картинок
        return ResponseEntity.ok().build();
    }

    }
