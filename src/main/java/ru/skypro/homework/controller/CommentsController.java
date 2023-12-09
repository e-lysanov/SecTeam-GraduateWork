package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.service.CommentsService;

/**
 * Контроллер для эндпоинтов комментариев.
 */
@Slf4j
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    /**
     * Получение комментариев объявления
     * @param id
     * @return
     */
    @GetMapping("{id}/comments")
    public CommentsDTO getComments(@RequestParam long id) {
        log.info("Эндпоинт получения комментариев объявления выполнен");
        return commentsService.getComments(id);
    }

    /**
     * Добавление комментария к объявлению
     * @param id
     * @param text
     * @return
     */
    @PostMapping("{id}/comments")
    public Comment addComment(@RequestParam long id,
                              @RequestBody CreateOrUpdateCommentDTO text,
                              Authentication authentication) {
        log.info("Эндпоинт добавления комментария выполнен");
        return commentsService.addComment(id, text, authentication);
    }

    /**
     * Удаление комментария
     * @param adId
     * @param commentId
     * @return
     */
    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@RequestParam int adId, @RequestParam int commentId) {
        commentsService.deleteComment(adId, commentId);
        log.info("Эндпоинт удаления комментария выполнен");
        return ResponseEntity.ok().build();
    }

    /**
     * Обновление комментария
     * @param adId
     * @param commentId
     * @param text
     * @return
     */
    @PatchMapping("{adId}/comments/{commentId}")
    public CreateOrUpdateCommentDTO updateComment(@RequestParam int adId,
                                                  @RequestParam int commentId,
                                                  @RequestBody CreateOrUpdateCommentDTO text) {
        log.info("Эндпоинт обновления комментария выполнен");
        return commentsService.updateComment(adId, commentId, text);
    }

}
