package ru.skypro.homework.service;

import ru.skypro.homework.dto.comments.Comments;
import ru.skypro.homework.dto.comments.CreateOrUpdateComment;

public interface CommentsService {
    Comments getComments(int id);
    CreateOrUpdateComment addComment(CreateOrUpdateComment text);
    void deleteComment(int adId, int commentId);
    CreateOrUpdateComment updateComment(int adId, int commentId, CreateOrUpdateComment text);
}
