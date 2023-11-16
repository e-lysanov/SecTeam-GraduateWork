package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.service.CommentsService;

/**
 * Реализация сервиса для комментариев
 */
@Service
public class CommentsServiceImpl implements CommentsService {
    /**
     * Получение комментариев объявления
     * @param id
     * @return
     */
    @Override
    public CommentsDTO getComments(int id) {
        return null;
    }

    /**
     * Добавление комментария к объявлению
     * @param text
     * @return
     */
    @Override
    public CreateOrUpdateCommentDTO addComment(CreateOrUpdateCommentDTO text) {
        return null;
    }

    /**
     * Удаление комментария
     * @param adId
     * @param commentId
     */
    @Override
    public void deleteComment(int adId, int commentId) {
    }

    /**
     * Обновление комментария
     * @param adId
     * @param commentId
     * @param text
     * @return
     */
    @Override
    public CreateOrUpdateCommentDTO updateComment(int adId, int commentId, CreateOrUpdateCommentDTO text) {
        return null;
    }
}
