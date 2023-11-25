package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.service.UsersService;

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
    public NewPasswordDTO setPassword(@RequestBody NewPasswordDTO newPassword) {
        return usersService.setPassword(newPassword);
    }

    /**
     * Получение информации об авторизованном пользователе
     * @return
     */
    @GetMapping("/me")
    public UserDTO getUser() {
        return usersService.getUser();
    }

    /**
     * Обновление информации об авторизованном пользователе
     * @param updateUser
     * @return
     */
    @PatchMapping("/me")
    public UpdateUserDTO updateUser(@RequestBody UpdateUserDTO updateUser) {
        return usersService.updateUser(updateUser);
    }

    /**
     * Обновление аватара авторизованного пользователя
     * @param avatar
     * @return
     */
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAvatar(@RequestBody MultipartFile avatar) {
        usersService.updateAvatar(avatar);
        return ResponseEntity.ok().build();
//        if (usersService.updateAvatar(avatar)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
    }
}

