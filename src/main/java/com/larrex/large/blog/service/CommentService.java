package com.larrex.large.blog.service;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.entity.Comment;
import com.larrex.large.exception.NotFoundExceptionHandler;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment update(Comment comment,String commentId) throws NotFoundExceptionHandler;
    Comment getCommentById(String commentId) throws NotFoundExceptionHandler;
    void deleteComment(String commentId);
}
