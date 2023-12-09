package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UsersService;

/**
 * Реализация сервиса для работы с пользователем
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    /**
     * Обновление пароля
     * @param newPassword
     * @return
     */
    @Override
    public void setPassword(NewPasswordDTO newPassword, Authentication authentication) {

    }

    /**
     * Получение информации об авторизованном пользователе
     * @return
     */
    @Override
    public UserDTO getUser(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        log.info("Метод получения информации авторизованного пользователя выполнен");
        return userMapper.toDto(user);
    }

    /**
     * Обновление информации об авторизованном пользователе
     * @param updateUser
     * @return
     */
    @Override
    public UpdateUserDTO updateUser(UpdateUserDTO updateUser, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(updateUser.getPhone());
        userRepository.save(user);
        UpdateUserDTO updateUserDTO = userMapper.toUpdateDto(user);
        log.info("Метод обновления данных авторизованного пользователя выполнен");
        return updateUserDTO;
    }

    /**
     * Обновление аватара авторизованного пользователя
     *
     * @param avatar
     */
    @Override
    public void updateAvatar(MultipartFile avatar, Authentication authentication) {
    }
}
