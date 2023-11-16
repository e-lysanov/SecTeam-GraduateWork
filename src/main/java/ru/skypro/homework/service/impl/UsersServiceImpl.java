package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPassword;
import ru.skypro.homework.dto.users.UpdateUser;
import ru.skypro.homework.dto.users.User;
import ru.skypro.homework.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public NewPassword setPassword(NewPassword newPassword) {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public UpdateUser updateUser(UpdateUser updateUser) {
        return null;
    }

    @Override
    public User updateAvatar(MultipartFile avatar) {
        return null;
    }
}
