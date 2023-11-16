package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comments.Comments;
import ru.skypro.homework.dto.comments.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService {
    @Override
    public Comments getComments(int id) {
        return null;
    }

    @Override
    public CreateOrUpdateComment addComment(CreateOrUpdateComment text) {
        return null;
    }

    @Override
    public void deleteComment(int adId, int commentId) {

    }

    @Override
    public CreateOrUpdateComment updateComment(int adId, int commentId, CreateOrUpdateComment text) {
        return null;
    }
}
