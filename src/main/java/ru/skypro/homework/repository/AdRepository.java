package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Ad;

/**
 * Репозиторий для связи с таблицей объявлений из БД.
 */
public interface AdRepository extends JpaRepository<Ad, Integer> {
}
