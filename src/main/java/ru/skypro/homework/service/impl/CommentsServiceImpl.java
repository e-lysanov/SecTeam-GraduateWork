package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.mappers.CommentMapper;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentsService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для комментариев
 */
@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
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
