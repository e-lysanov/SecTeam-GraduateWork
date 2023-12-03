package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UsersService;

/**
 * Реализация сервиса для работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    /**
     * Обновление пароля
     * @param newPassword
     * @return
     */
    @Override
    public NewPasswordDTO setPassword(NewPasswordDTO newPassword) {
        return null;
    }

    /**
     * Получение информации об авторизованном пользователе
     * @return
     */
    @Override
    public UserDTO getUser() {
        return null;
    }

    /**
     * Обновление информации об авторизованном пользователе
     * @param updateUser
     * @return
     */
    @Override
    public UpdateUserDTO updateUser(UpdateUserDTO updateUser) {
        return null;
    }

    /**
     * Обновление аватара авторизованного пользователя
     *
     * @param avatar
     */
    @Override
    public void updateAvatar(MultipartFile avatar) {
    }
}
