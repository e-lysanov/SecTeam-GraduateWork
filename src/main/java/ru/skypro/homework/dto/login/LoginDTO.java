package ru.skypro.homework.dto.login;

import lombok.Data;

/**
 * Модель ДТО авторизации
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
}
