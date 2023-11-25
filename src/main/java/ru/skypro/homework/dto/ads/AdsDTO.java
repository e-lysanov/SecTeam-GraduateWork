package ru.skypro.homework.dto.ads;

import lombok.Data;

import java.util.Collection;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class AdsDTO {
    private int count;
    private Collection<AdDTO> results;
}
