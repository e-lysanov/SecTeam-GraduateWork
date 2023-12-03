package ru.skypro.homework.service;

import ru.skypro.homework.dto.login.LoginDTO;
import ru.skypro.homework.dto.register.RegisterDTO;

public interface AuthService {
//    boolean login(String userName, String password);

    boolean login(LoginDTO loginDTO);

    boolean register(RegisterDTO register);
}
