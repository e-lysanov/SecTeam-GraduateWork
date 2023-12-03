package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
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
    public CommentsDTO getComments(@RequestParam int id) {
        return commentsService.getComments(id);
    }

    /**
     * Добавление комментария к объявлению
     * @param id
     * @param text
     * @return
     */
    @PostMapping("{id}/comments")
    public CreateOrUpdateCommentDTO addComment(@RequestParam int id,
                                               @RequestBody CreateOrUpdateCommentDTO text) {
        return commentsService.addComment(text);
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
        return commentsService.updateComment(adId, commentId, text);
    }

}
