package ru.skypro.homework.controller;

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
import ru.skypro.homework.service.UsersService;

import java.io.IOException;

/**
 * Контроллер для эндпоинтов для работы с авторизованным пользователем.
 */
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    /**
     * Обновление пароля
     * @param newPassword
     * @return
     */
    @PostMapping("/set_password")
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
    @GetMapping("/me")
    public UserDTO getUser(Authentication authentication) {
        log.info("Эндпоинт получения информации авторизованного пользователя выполнен");
        return usersService.getUser(authentication);
    }

    /**
     * Обновление информации об авторизованном пользователе
     * @param updateUser
     * @return
     */
    @PatchMapping("/me")
    public UpdateUserDTO updateUser(@RequestBody UpdateUserDTO updateUser, Authentication authentication) {
        log.info("Эндпоинт обновления данных авторизованного пользователя выполнен");
        return usersService.updateUser(updateUser, authentication);
    }

    /**
     * Обновление аватара авторизованного пользователя
     * @param avatar
     * @return
     */
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateAvatar(@RequestBody MultipartFile avatar, Authentication authentication) throws IOException {
        usersService.updateAvatar(avatar, authentication);
        return ResponseEntity.ok().build();
//        if (usersService.updateAvatar(avatar)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
    }
}

