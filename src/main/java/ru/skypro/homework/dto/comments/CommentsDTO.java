package ru.skypro.homework.dto.comments;

import lombok.Data;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class CommentsDTO {
    private int count;
    private CommentDTO results;
}
