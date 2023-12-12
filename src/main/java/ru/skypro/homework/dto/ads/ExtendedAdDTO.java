package ru.skypro.homework.dto.ads;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель с информацией об объявлении
 */
@Data
public class ExtendedAdDTO {
    @Schema(description = "id объявления")
    private int pk;

    @Schema(description = "имя автора объявления")
    private String authorFirstName;

    @Schema(description = "фамилия автора объявления")
    private String authorLastName;

    @Schema(description = "описание объявления")
    private String description;

    @Schema(description = "логин автора объявления")
    private String email;

    @Schema(description = "ссылка на картинку объявления")
    private String image;

    @Schema(description = "телефон автора объявления")
    private String phone;

    @Schema(description = "цена объявления")
    private int price;

    @Schema(description = "заголовок объявления")
    private String title;
}
