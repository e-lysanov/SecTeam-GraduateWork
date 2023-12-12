package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateCommentDTO;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.service.CommentsService;

/**
 * Контроллер для эндпоинтов комментариев.
 */
@Tag(name = "Комментарии")
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
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
    @Operation(summary = "Получение комментариев объявления")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CommentsDTO.class))
            ),
            @ApiResponse(responseCode = "401", content = @Content),
            @ApiResponse(responseCode = "404", content = @Content)
    })
    @GetMapping("{id}/comments")
    public CommentsDTO getComments(@PathVariable long id) {
        log.info("Эндпоинт получения комментариев объявления выполнен" + commentsService.getComments(id));
        return commentsService.getComments(id);
    }

    /**
     * Добавление комментария к объявлению
     * @param id
     * @param text
     * @return
     */
    @Operation(summary = "Добавление комментария к объявлению")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CommentDTO.class))
            ),
            @ApiResponse(responseCode = "401", content = @Content),
            @ApiResponse(responseCode = "404", content = @Content)
    })
    @PostMapping(value = "{id}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentDTO addComment(@PathVariable long id,
                              @RequestBody CreateOrUpdateCommentDTO text,
                              Authentication authentication) {
        log.info("Эндпоинт добавления комментария выполнен" + commentsService.addComment(id, text, authentication));
        return commentsService.addComment(id, text, authentication);
    }

    /**
     * Удаление комментария
     * @param adId
     * @param commentId
     * @return
     */
    @Operation(summary = "Удаление комментария")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "401", content = @Content),
            @ApiResponse(responseCode = "403", content = @Content),
            @ApiResponse(responseCode = "404", content = @Content)
    })
    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int adId, @PathVariable int commentId) {
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
    @Operation(summary = "Обновление комментария")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CommentDTO.class))
            ),
            @ApiResponse(responseCode = "401", content = @Content),
            @ApiResponse(responseCode = "403", content = @Content),
            @ApiResponse(responseCode = "404", content = @Content)
    })
    @PatchMapping(value = "{adId}/comments/{commentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentDTO updateComment(@PathVariable int adId,
                                    @PathVariable int commentId,
                                    @RequestBody CreateOrUpdateCommentDTO text) {
        log.info("Эндпоинт обновления комментария выполнен" + commentsService.updateComment(adId, commentId, text));
        return commentsService.updateComment(adId, commentId, text);
    }

}
