package ru.skypro.homework.dto.users;

import lombok.Data;

/**
 * Модель ДТО пароля
 */
@Data
public class NewPasswordDTO {
    private String currentPassword;
    private String newPassword;
}
