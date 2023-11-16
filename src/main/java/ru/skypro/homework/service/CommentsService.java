package ru.skypro.homework.service;

import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;

public interface CommentsService {
    CommentsDTO getComments(int id);
    CreateOrUpdateCommentDTO addComment(CreateOrUpdateCommentDTO text);
    void deleteComment(int adId, int commentId);
    CreateOrUpdateCommentDTO updateComment(int adId, int commentId, CreateOrUpdateCommentDTO text);
}
