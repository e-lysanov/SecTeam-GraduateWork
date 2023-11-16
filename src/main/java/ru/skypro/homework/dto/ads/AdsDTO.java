package ru.skypro.homework.dto.ads;

import lombok.Data;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class AdsDTO {
    private int count;
    private AdDTO results;
}
