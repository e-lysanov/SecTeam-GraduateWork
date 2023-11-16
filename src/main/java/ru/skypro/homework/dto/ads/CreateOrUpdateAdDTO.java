package ru.skypro.homework.dto.ads;

import lombok.Data;

/**
 * Модель ДТО создания или обновления объявления
 */
@Data
public class CreateOrUpdateAdDTO {
    private String title;
    private int price;
    private String description;
}
