package ru.skypro.homework.service;

import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.model.Comment;

import java.util.List;

public interface CommentsService {
    CommentsDTO getComments(long id);
    Comment addComment(long id, CreateOrUpdateCommentDTO text);
    void deleteComment(long adId, long commentId);
    CreateOrUpdateCommentDTO updateComment(long adId, long commentId, CreateOrUpdateCommentDTO text);
}
