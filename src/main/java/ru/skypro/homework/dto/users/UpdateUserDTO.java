package ru.skypro.homework.dto.users;

import lombok.Data;

/**
 * Модель ДТО обновления пользователя
 */
@Data
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String phone;
}
