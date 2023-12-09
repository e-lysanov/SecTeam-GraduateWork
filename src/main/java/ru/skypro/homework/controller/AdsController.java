package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;


/**
 * Контроллер для эндпоинтов объявлений.
 */
@Slf4j
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;
    private final ImageService imageService;

    /**
     * Получение всех объявлений
     *
     * @return
     */
    @GetMapping
    public AdsDTO getAds() {
        log.info("Эндпоинт получения всех объявлений выполнен");
        return adsService.getAds();
    }

    /**
     * Добавление объявления
     *
     * @param createAdDTO
     * @param image
     * @return
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdDTO addAd(@RequestPart("Объявление") CreateOrUpdateAdDTO createAdDTO,
                       @RequestPart("Изображение") MultipartFile image,
                       Authentication authentication) throws IOException {
        log.info("Эндпоинт добавления нового объявления выполнен");
        return adsService.addAd(createAdDTO, image, authentication);

    }


    /**
     * Получение информации об объявлении
     *
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
     *
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
     *
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
     *
     * @return
     */
    @GetMapping("/me")
    public AdsDTO getMyAds(Authentication authentication) {
        log.info("Эндпоинт получения объявлений авторизованного пользователя выполнен");
        return adsService.getMyAds(authentication);
    }

    /**
     * Обновление картинки объявления
     *
     * @param id
     * @param image
     * @return
     */
    @PatchMapping(value = "/{id}/image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void updateImage(@PathVariable long id,
                              @RequestPart("Изображение") MultipartFile image) throws IOException {
        // ----- метод не работает
        adsService.updateImage(id, image);

    }

}
