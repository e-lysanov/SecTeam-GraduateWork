package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;

import java.io.IOException;

public interface ImageService {
    void uploadAdImage(long adId, MultipartFile image) throws IOException;
    Image findAdImage(long adId);
}
