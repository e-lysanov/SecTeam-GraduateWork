package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;

/**
 * Маппер комментариев
 */
@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    @Mapping(source = "user.id", target = "author")
    CommentDTO toDto(Comment comment, User user);
}
