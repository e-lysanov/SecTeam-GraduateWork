package ru.skypro.homework.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель ДТО обновления пользователя
 */
@Data
public class UpdateUserDTO {
    @Schema(description = "имя пользователя", minLength = 3, maxLength = 10)
    private String firstName;

    @Schema(description = "фамилия пользователя", minLength = 3, maxLength = 10)
    private String lastName;

    @Schema(description = "телефон пользователя", pattern = "(\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2})")
    private String phone;
}
