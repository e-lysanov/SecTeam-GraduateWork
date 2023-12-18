package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Image;

import java.util.Optional;

/**
 * Репозиторий для связи с таблицей картинок из БД.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByAdPk(long id);
    Optional<Image> findByUserId (long id);
}
