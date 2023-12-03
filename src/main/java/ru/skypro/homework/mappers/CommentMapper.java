package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;

/**
 * Маппер комментариев
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.id", target = "author")
    CommentDTO toDto(Comment comment, User user);
    @Mapping(source = "userDTO", target = "author")
    Comment toModel(CommentDTO commentDTO, UserDTO userDTO);
}
