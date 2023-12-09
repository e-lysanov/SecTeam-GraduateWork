package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.User;

/**
 * Маппер пользователя
 */
//@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toModel(UserDTO userDTO);

    User toUpdateModel(UpdateUserDTO updateUserDTO);
    @Mapping(source = "registerDTO.username", target = "email")
    User registerToModel(RegisterDTO registerDTO);

    UpdateUserDTO toUpdateDto(User user);

}
