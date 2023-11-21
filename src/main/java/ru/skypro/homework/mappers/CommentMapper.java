package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;

/**
 * Маппер комментариев
 */
@Mapper
public interface CommentMapper {
    @Mapping(source = "user.id", target = "author")
    CommentDTO toDto(Comment comment, User user);
}
