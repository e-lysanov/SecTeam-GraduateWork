package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.mappers.AdMapper;
import ru.skypro.homework.mappers.CommentMapper;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.CommentsService;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для комментариев
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CommentsServiceImpl implements CommentsService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final AdRepository adRepository;
    private final CommentMapper commentMapper;
    private final AdMapper adMapper;

    /**
     * Получение комментариев объявления
     *
     * @param id
     * @return
     */
    @Override
    public CommentsDTO getComments(long id) {
        List<Comment> comments = commentRepository.findAllByAdPk(id);
        List<CommentDTO> commentDTOs = new ArrayList<>();
        CommentsDTO commentsDTOs = new CommentsDTO(1, null);
        for (Comment comment : comments) {
            CommentDTO commentDTO = commentMapper.toDto(comment, comment.getAuthor());
            commentDTOs.add(commentDTO);
        }
        commentsDTOs.setCount(commentDTOs.size());
        commentsDTOs.setResults(commentDTOs);
        log.info("Метод получения комментариев объявления выполнен");
        return commentsDTOs;
    }

    /**
     * Добавление комментария к объявлению
     *
     * @param text
     * @return
     */
    @Override
    public Comment addComment(long id, CreateOrUpdateCommentDTO text, Authentication authentication) {
        // ----- Метод выдаёт ошибку
        LocalDateTime dateTime = LocalDateTime.now();
        long millisecondsCreatedComment = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        Ad ad = adRepository.findByPk(id);
        User author = userRepository.findByEmail(authentication.getName());
        Comment newComment = commentMapper.toCreateModel(text);
        commentRepository.save(newComment);
        newComment.setAd(ad);
        newComment.setAuthor(author);
        newComment.setCreatedAt((int) millisecondsCreatedComment);
        newComment.setAuthorFirstName(author.getFirstName());
        newComment.setAuthorImage(author.getImage());
        log.info("Метод добавления комментария выполнен");
        return newComment;
    }

    /**
     * Удаление комментария
     *
     * @param adId
     * @param commentId
     */
    @Override
    public void deleteComment(long adId, long commentId) {
        List<Comment> comments = commentRepository.findAllByAdPk(adId);
        Comment deletedComment = null;
        for (int i = 0; i < comments.size(); i++) {
            deletedComment = commentRepository.findById(commentId).orElse(null);
        }
        commentRepository.delete(deletedComment);
        log.info("Метод удаления объявления выполнен");
    }

    /**
     * Обновление комментария
     *
     * @param adId
     * @param commentId
     * @param text
     * @return
     */
    @Override
    public CreateOrUpdateCommentDTO updateComment(long adId, long commentId, CreateOrUpdateCommentDTO text) {
        Comment savedComment = commentRepository.findById(commentId).orElse(null);
        List<Comment> adComments = commentRepository.findAllByAdPk(adId);
        for (int i = 0; i < adComments.size(); i++) {
            if (i == commentId){
                Comment newComment = commentMapper.toCreateModel(text);
                commentRepository.save(newComment);
                CreateOrUpdateCommentDTO createOrUpdateCommentDTO = commentMapper.toCreateModel(newComment, newComment.getAuthor());
                log.info("Метод обновления комментария выполнен, текст обновлен");
                return createOrUpdateCommentDTO;
            }
        }
        log.info("Метод обновления выполнен, текст не обновлен, произошла ошибка");
        return null;
    }
}
