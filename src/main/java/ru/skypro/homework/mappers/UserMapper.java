package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.User;

/**
 * Маппер пользователя
 */
@Mapper
public interface UserMapper {
    UserDTO toDto(User user);

//    User toModel()
}
