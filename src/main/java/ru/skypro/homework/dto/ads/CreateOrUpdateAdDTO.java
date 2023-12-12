package ru.skypro.homework.dto.ads;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель ДТО создания или обновления объявления
 */
@Data
public class CreateOrUpdateAdDTO {
    @Schema(description = "заголовок объявления", minLength = 4, maxLength = 32)
    private String title;

    @Schema(description = "цена объявления", minimum = "0", maximum = "10000000")
    private int price;

    @Schema(description = "описание объявления", minLength = 8, maxLength = 64)
    private String description;
}
