package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Comment;

import java.util.List;

/**
 * Репозиторий для связи с таблицей комментариев из БД.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByAdPk (long adId);
}
