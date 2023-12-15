package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;

/**
 * Маппер пользователя
 */
//@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.image", qualifiedByName = "imageToString", target = "image")
    UserDTO toDto(User user);

    User toUpdateModel(UpdateUserDTO updateUserDTO);
    @Mapping(source = "registerDTO.username", target = "email")
    User registerToModel(RegisterDTO registerDTO);
    UpdateUserDTO toUpdateDto(User user);

    @Named("imageToString")
    default String imageToString(Image image){

        return "/user/avatar/"+ image.getId();

    }
}
