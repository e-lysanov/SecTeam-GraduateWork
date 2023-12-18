package ru.skypro.homework.dto.comments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель ДТО создания или обновления комментария
 */
@Data
public class CreateOrUpdateCommentDTO {
    @Schema(description = "текст комментария", minLength = 8, maxLength = 64)
    private String text;
}
