package com.larrex.large.blog.serviceimpl;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.entity.Comment;
import com.larrex.large.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Override
    public Comment createComment(Article article) {
        return null;
    }

    @Override
    public Comment update(Article article, String commentId) {
        return null;
    }

    @Override
    public Comment getCommentById(String commentId) {
        return null;
    }

    @Override
    public void deleteComment(String commentId) {

    }
}
