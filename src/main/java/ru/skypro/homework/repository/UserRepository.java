package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.User;

/**
 * Репозиторий для связи с таблицей пользователей из БД.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
