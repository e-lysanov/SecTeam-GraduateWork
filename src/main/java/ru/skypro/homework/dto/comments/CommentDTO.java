package ru.skypro.homework.dto.comments;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель ДТО комментария
 */
@Data
public class CommentDTO {
    @Schema(description = "id автора комментария")
    private int author;

    @Schema(description = "ссылка на аватар автора комментария")
    private String authorImage;

    @Schema(description = "имя создателя комментария")
    private String authorFirstName;

    @Schema(description = "дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970")
    private int createdAt;

    @Schema(description = "id комментария")
    private int pk;

    @Schema(description = "текст комментария")
    private String text;
}
