package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Ad;

import java.util.List;

/**
 * Репозиторий для связи с таблицей объявлений из БД.
 */
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByPk(long adId);
    List<Ad> findAllByAuthorId (long userId);
}
