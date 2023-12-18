package ru.skypro.homework.dto.comments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * Модель ДТО всех объявлений
 */
@Data
public class CommentsDTO {
    @Schema(description = "общее количество комментариев")
    private int count;

    private Collection<CommentDTO> results;

    public CommentsDTO(int size, List<CommentDTO> commentsDTO) {
    }
}
