package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.User;

/**
 * Маппер пользователя
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDto(User user);
}
