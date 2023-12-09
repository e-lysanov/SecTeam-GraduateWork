package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.users.NewPasswordDTO;
import ru.skypro.homework.dto.users.UpdateUserDTO;
import ru.skypro.homework.dto.users.UserDTO;

import java.io.IOException;

public interface UsersService {
    void setPassword(NewPasswordDTO newPassword, Authentication authentication);
    UserDTO getUser(Authentication authentication);
    UpdateUserDTO updateUser(UpdateUserDTO updateUser, Authentication authentication);
    void updateAvatar(MultipartFile avatar, Authentication authentication) throws IOException;
}
