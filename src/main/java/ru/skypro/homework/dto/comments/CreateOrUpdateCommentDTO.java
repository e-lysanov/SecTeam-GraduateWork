package ru.skypro.homework.dto.comments;

import lombok.Data;

/**
 * Модель ДТО создания или обновления комментария
 */
@Data
public class CreateOrUpdateCommentDTO {
    private String text;
}
