package ru.skypro.homework.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель ДТО авторизации
 */
@Data
public class LoginDTO {
    @Schema(description = "логин", minLength = 4, maxLength = 32)
    private String username;

    @Schema(description = "пароль", minLength = 8, maxLength = 16)
    private String password;
}
