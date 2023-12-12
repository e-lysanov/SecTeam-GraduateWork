package ru.skypro.homework.dto.register;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.skypro.homework.enums.Role;

/**
 * Модель ДТО регистрации
 */
@Data
public class RegisterDTO {
    @Schema(description = "логин", minLength = 4, maxLength = 32)
    private String username;

    @Schema(description = "пароль", minLength = 8, maxLength = 16)
    private String password;

    @Schema(description = "имя пользователя", minLength = 2, maxLength = 16)
    private String firstName;

    @Schema(description = "фамилия пользователя", maxLength = 2, minLength = 16)
    private String lastName;

    @Schema(description = "телефон пользователя", pattern = "(\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2})")
    private String phone;

    @Schema(description = "роль пользователя")
    private Role role;
}
