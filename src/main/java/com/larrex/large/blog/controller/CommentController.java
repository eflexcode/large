package com.larrex.large.blog.controller;

import com.larrex.large.blog.entity.Comment;
import com.larrex.large.blog.service.CommentService;
import com.larrex.large.exception.NotFoundExceptionHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/postComment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @PostMapping("/updateComment/{commentId}")
    public Comment update(@PathVariable(name = "commentId") String commentId, @RequestBody Comment sentComment) throws NotFoundExceptionHandler {
        return commentService.update(sentComment, commentId);
    }

    @GetMapping("/get/{commentId}")
    public Comment getCommentById(@PathVariable(name = "commentId") String commentId) throws NotFoundExceptionHandler {
        return commentService.getCommentById(commentId);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") String commentId) {
        commentService.deleteComment(commentId);
    }
}
