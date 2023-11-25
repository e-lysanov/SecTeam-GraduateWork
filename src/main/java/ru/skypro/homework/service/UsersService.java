package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;

public interface UsersService {
    NewPasswordDTO setPassword(NewPasswordDTO newPassword);
    UserDTO getUser();
    UpdateUserDTO updateUser(UpdateUserDTO updateUser);
    void updateAvatar(MultipartFile avatar);
}
