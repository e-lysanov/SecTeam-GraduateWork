package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.register.RegisterDTO;
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
    User registerToModel(RegisterDTO registerDTO);
}
