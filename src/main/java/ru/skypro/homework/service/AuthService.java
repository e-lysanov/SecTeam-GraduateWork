package ru.skypro.homework.service;

import ru.skypro.homework.dto.register.RegisterDTO;

public interface AuthService {
    boolean login(String userName, String password);

    boolean register(RegisterDTO register);
}
