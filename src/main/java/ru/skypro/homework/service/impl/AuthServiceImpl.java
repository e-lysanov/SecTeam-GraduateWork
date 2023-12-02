package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

/**
 * Реализация сервиса для авторизации и регистрации
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MyUserDetailsService myUserDetailsService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Авторизация
     * @param userName
     * @param password
     * @return
     */

    @Override
    public boolean login(String userName, String password) {
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(userName);
        if (userDetails == null) {
            return false;
        }
        return encoder.matches(encoder.encode(password), userDetails.getPassword());
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
        User user = userMapper.registerToModel(register);
        userRepository.save(user);
        return true;
    }

}
