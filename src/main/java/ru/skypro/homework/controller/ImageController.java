package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.service.ImageService;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Изображения")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {
private final ImageService imageService;

    @GetMapping("user/avatar/{id}")
    public ResponseEntity<byte[]> getUsersAvatar(@PathVariable Integer id, Authentication authentication) {
        return ResponseEntity.ok(imageService.findUserImage(id).getData());
    }

    @GetMapping("ads/adImage/{id}")
    public ResponseEntity<byte[]> getAdsImage(@PathVariable Integer id, Authentication authentication) {
        return ResponseEntity.ok(imageService.findAdImage(id).getData());
    }
}
