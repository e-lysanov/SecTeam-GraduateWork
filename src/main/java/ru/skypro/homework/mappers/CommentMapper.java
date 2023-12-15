package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;

/**
 * Маппер комментариев
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "user.image", qualifiedByName = "imageToString", target = "authorImage")
    CommentDTO toDto(Comment comment, User user);

    Comment toCreateModel(CreateOrUpdateCommentDTO commentDTO);

    @Named("imageToString")
    default String imageToString(Image image){
        if (image == null) {
            return null;
        }
        return "/images/image/"+ image.getId();

    }
}
