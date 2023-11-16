package ru.skypro.homework.dto.comments;

import lombok.Data;

/**
 * Модель ДТО комментария
 */
@Data
public class CommentDTO {
    private int author;
    private String authorImage;
    private String authorFirstName;
    private int createdAt;
    private int pk;
    private String text;
}
