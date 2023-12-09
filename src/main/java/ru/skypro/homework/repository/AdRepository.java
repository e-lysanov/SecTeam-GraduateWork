package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Ad;

/**
 * Репозиторий для связи с таблицей объявлений из БД.
 */
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad getByPk(long adId);
}
