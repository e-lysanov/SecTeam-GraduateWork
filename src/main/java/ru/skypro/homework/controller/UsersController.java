package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UsersService;

import java.io.IOException;

/**
 * Контроллер для эндпоинтов для работы с авторизованным пользователем.
 */
@Tag(name = "Пользователи")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final ImageService imageService;

    /**
     * Обновление пароля
     * @param newPassword
     * @return
     */
    @Operation(summary = "Обновление пароля")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "401", content = @Content),
            @ApiResponse(responseCode = "403", content = @Content)
    })
    @PostMapping(value = "/set_password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setPassword(@RequestBody NewPasswordDTO newPassword, Authentication authentication) {
        if (usersService.setPassword(newPassword, authentication)) {
            log.info("Эндпоинт обновления пароля выполнен");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            log.info("Эндпоинт обновления пароля не выполнен");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Получение информации об авторизованном пользователе
     * @return
     */
    @Operation(summary = "Получение информации об авторизованном пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "401", content = @Content)
    })
    @GetMapping("/me")
    public UserDTO getUser(Authentication authentication) {
        log.info("Эндпоинт получения информации авторизованного пользователя выполнен" + usersService.getUser(authentication));
        return usersService.getUser(authentication);
    }

    /**
     * Обновление информации об авторизованном пользователе
     * @param updateUser
     * @return
     */
    @Operation(summary = "Обновление информации об авторизованном пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UpdateUserDTO.class))),
            @ApiResponse(responseCode = "401", content = @Content)
    })
    @PatchMapping(value = "/me", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UpdateUserDTO updateUser(@RequestBody UpdateUserDTO updateUser, Authentication authentication) {
        log.info("Эндпоинт обновления данных авторизованного пользователя выполнен");
        return usersService.updateUser(updateUser, authentication);
    }

    /**
     * Обновление аватара авторизованного пользователя
     * @param image
     * @return
     */
    @Operation(summary = "Обновление аватара авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "401", content = @Content)
    })
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateAvatar(@RequestBody MultipartFile image, Authentication authentication) throws IOException {
        usersService.updateAvatar(image, authentication);
        log.info("Эндпоинт обновления аватара выполнен");
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/image/{id}")
//    public ResponseEntity<byte[]> getUsersImage(@PathVariable Integer id, Authentication authentication) {
//        log.info("Эндпоинт получения картинки пользователя выполнен");
//       return ResponseEntity.ok(imageService.getById(id));
//    }

}

