package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;

import java.io.IOException;

public interface ImageService {
    Image uploadAdImage(long adId, MultipartFile image) throws IOException;
    Image uploadUserAvatar(MultipartFile image, Authentication authentication) throws IOException;
    Image findImage(long adId);
}
