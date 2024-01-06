package com.larrex.large.blog.service;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.entity.Comment;

public interface CommentService {
    Comment createComment(Article article);
    Comment update(Article article,String commentId);
    Comment getCommentById(String commentId);
    void deleteComment(String commentId);
}
