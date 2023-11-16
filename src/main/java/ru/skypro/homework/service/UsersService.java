package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPassword;
import ru.skypro.homework.dto.users.UpdateUser;
import ru.skypro.homework.dto.users.User;

public interface UsersService {
    NewPassword setPassword(NewPassword newPassword);
    User getUser();
    UpdateUser updateUser(UpdateUser updateUser);
    User updateAvatar(MultipartFile avatar);
}
