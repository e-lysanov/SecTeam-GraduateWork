package ru.skypro.homework.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.skypro.homework.enums.Role;

/**
 * Модель ДТО пользователя
 */
@Data
public class UserDTO {
    @Schema(description = "id пользователя")
    private int id;

    @Schema(description = "логин пользователя")
    private String email;

    @Schema(description = "имя пользователя")
    private String firstName;

    @Schema(description = "фамилия пользователя")
    private String lastName;

    @Schema(description = "телефон пользователя")
    private String phone;

    private Role role;

    @Schema(description = "ссылка на аватар пользователя")
    private String image;
}
