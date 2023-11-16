package ru.skypro.homework.dto.ads;

import lombok.Data;

/**
 * Модель ДТО объявления
 */
@Data
public class AdDTO {
    private int author;
    private String image;
    private int pk;
    private int price;
    private String title;
}
