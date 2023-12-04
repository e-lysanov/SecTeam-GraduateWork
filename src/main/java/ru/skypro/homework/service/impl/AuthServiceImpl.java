package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.login.LoginDTO;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

/**
 * Реализация сервиса для авторизации и регистрации
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MyUserDetailsService myUserDetailsService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Авторизация
     * @param loginDTO
     * @return
     */

    @Override
    public boolean login(LoginDTO loginDTO) {
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginDTO.getUsername());
        if (userDetails == null) {
            return false;
        }
        log.info("Метод Логин сработал");
        return encoder.matches(loginDTO.getPassword(), userDetails.getPassword());
    }

    /**
     * Регистрация
     * @param register
     * @return
     */
    @Override
    public boolean register(RegisterDTO register) {
        if (myUserDetailsService.loadUserByUsername(register.getUsername()) != null) {
            return false;
        }
        register.setPassword(encoder.encode(register.getPassword()));
        log.info("Пароль при регистрации закодировался");
        User user = userMapper.registerToModel(register);
        userRepository.save(user);
        log.info("Метод регистрации прошёл, пользователь сохранен в БД");
        return true;
    }

}
