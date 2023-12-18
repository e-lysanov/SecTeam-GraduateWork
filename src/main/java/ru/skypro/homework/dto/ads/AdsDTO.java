package ru.skypro.homework.dto.ads;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class AdsDTO {
    @Schema(description = "общее количество объявлений")
    private int count;

    private Collection<AdDTO> results;

    public AdsDTO(int count, Collection<AdDTO> results) {
    }
}
