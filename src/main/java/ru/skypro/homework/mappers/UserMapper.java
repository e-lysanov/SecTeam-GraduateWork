package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
    @Mapping(source = "image.id", target = "image")
    UserDTO toDto(User user, Image image);

    User toModel(UserDTO userDTO);
    User toUpdateModel(UpdateUserDTO updateUserDTO);
    @Mapping(source = "registerDTO.username", target = "email")
    User registerToModel(RegisterDTO registerDTO);
    UpdateUserDTO toUpdateDto(User user);
    NewPasswordDTO toNewPasswordDto(User user);
}
