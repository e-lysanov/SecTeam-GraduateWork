package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import java.io.IOException;


/**
 * Контроллер для эндпоинтов объявлений.
 */
@Tag (name = "Объявления")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;

    /**
     * Получение всех объявлений
     *
     * @return
     */
    @Operation(summary = "Получение всех объявлений")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AdsDTO.class))
            )
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdsDTO getAds() {
        log.info("Эндпоинт получения всех объявлений выполнен" + adsService.getAds());
        return adsService.getAds();
    }

    /**
     * Добавление объявления
     *
     * @param createAdDTO
     * @param image
     * @return
     */
    @Operation(summary = "Добавление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AdDTO.class))),
            @ApiResponse(responseCode = "401", content = @Content)
})
@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public AdDTO addAd(@RequestPart("Объявление") CreateOrUpdateAdDTO createAdDTO,
@RequestPart("Изображение") MultipartFile image,
        Authentication authentication)throws IOException{
        log.info("Эндпоинт добавления нового объявления выполнен");
        return adsService.addAd(createAdDTO,image,authentication);
        }


/**
 * Получение информации об объявлении
 *
 * @param id
 * @return
 */
@Operation(summary = "Получение информации об объявлении")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ExtendedAdDTO.class))),
        @ApiResponse(responseCode = "401", content = @Content),
        @ApiResponse(responseCode = "404", content = @Content)
})
@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ExtendedAdDTO getInfoAd(@PathVariable int id){
        log.info("Эндпоинт получения информации об объявлении выполнен"+adsService.getAd(id));
        return adsService.getAd(id);
        }

/**
 * Удаление объявления
 *
 * @param id
 */
@Operation(summary = "Удаление объявления")
@ApiResponses(value = {
        @ApiResponse(responseCode = "204", content = @Content),
        @ApiResponse(responseCode = "401", content = @Content),
        @ApiResponse(responseCode = "403", content = @Content),
        @ApiResponse(responseCode = "404", content = @Content)
})
@DeleteMapping("{id}")
public ResponseEntity<?> deleteAd(@PathVariable int id){
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
@Operation(summary = "Обновление информации об объявлении")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = AdDTO.class))),
        @ApiResponse(responseCode = "401", content = @Content),
        @ApiResponse(responseCode = "403", content = @Content),
        @ApiResponse(responseCode = "404", content = @Content)
})
@PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public AdDTO updateAd(@PathVariable int id,@RequestBody CreateOrUpdateAdDTO createOrUpdateAd){
        log.info("Эндпоинт обновления объявления выполнен");
        return adsService.updateAd(id,createOrUpdateAd);
        }

/**
 * Получение объявлений авторизованного пользователя
 *
 * @return
 */
@Operation(summary = "Обновление информации об объявлении")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = AdsDTO.class))),
        @ApiResponse(responseCode = "401", content = @Content)
})
@GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
public AdsDTO getMyAds(Authentication authentication){
        log.info("Эндпоинт получения объявлений авторизованного пользователя выполнен"+adsService.getMyAds(authentication));
        return adsService.getMyAds(authentication);
        }

/**
 * Обновление картинки объявления
 *
 * @param id
 * @param image
 * @return
 */
@Operation(summary = "Обновление картинки объявления")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
                schema = @Schema (type = "string", format = "byte"))),
        @ApiResponse(responseCode = "401", content = @Content),
        @ApiResponse(responseCode = "403", content = @Content),
        @ApiResponse(responseCode = "404", content = @Content)
})
@PatchMapping(value = "/{id}/image",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public ResponseEntity<byte[]>updateImage(@PathVariable long id,
@RequestBody MultipartFile image)throws IOException{
        adsService.updateImage(id,image);
        log.info("Эндпоинт обновления картинки выполнен");
        return ResponseEntity.ok().build();
        }
        }
