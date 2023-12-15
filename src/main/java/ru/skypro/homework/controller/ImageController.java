package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.service.ImageService;

@Tag(name = "Изображения")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getUsersImage(@PathVariable Integer id, Authentication authentication) {
        log.info("Эндпоинт получения картинки пользователя выполнен");
        return ResponseEntity.ok(imageService.getById(id));
    }
}
