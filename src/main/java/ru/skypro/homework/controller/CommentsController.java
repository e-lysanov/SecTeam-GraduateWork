package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comments.Comments;
import ru.skypro.homework.dto.comments.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentsService;


@Slf4j
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @GetMapping("{id}/comments")
    public Comments getComments(@RequestParam int id) {
        return commentsService.getComments(id);
    }

    @PostMapping("{id}/comments")
    public CreateOrUpdateComment addComment(@RequestParam int id,
                                            @RequestBody CreateOrUpdateComment text) {
        return commentsService.addComment(text);
    }

    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity deleteComment(@RequestParam int adId, @RequestParam int commentId) {
        commentsService.deleteComment(adId, commentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{adId}/comments/{commentId}")
    public CreateOrUpdateComment updateComment(@RequestParam int adId,
                                               @RequestParam int commentId,
                                               @RequestBody CreateOrUpdateComment text) {
        return commentsService.updateComment(adId, commentId, text);
    }

}
