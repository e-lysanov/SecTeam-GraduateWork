package ru.skypro.homework.dto.comments;

import lombok.Data;

import java.util.Collection;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class CommentsDTO {
    private int count;
    private Collection<CommentDTO> results;
}
