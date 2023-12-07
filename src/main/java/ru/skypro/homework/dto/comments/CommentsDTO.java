package ru.skypro.homework.dto.comments;

import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class CommentsDTO {
    private int count;
    private Collection<CommentDTO> results;

    public CommentsDTO(int size, List<CommentDTO> commentsDTO) {
    }
}
