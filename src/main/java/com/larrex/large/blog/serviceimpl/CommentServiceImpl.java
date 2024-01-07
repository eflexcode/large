package com.larrex.large.blog.serviceimpl;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.entity.Comment;
import com.larrex.large.blog.repository.ArticleRepository;
import com.larrex.large.blog.repository.CommentRepository;
import com.larrex.large.blog.service.CommentService;
import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    @Override
    public Comment createComment(Comment comment) {
        Date date = new Date();
        comment.setCreatedAt(date);
        comment.setUpdatedAt(date);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment sentComment, String commentId) throws NotFoundExceptionHandler {

        Comment comment = getCommentById(commentId);
        comment.setArticleId(sentComment.getArticleId() != null ? sentComment.getArticleId() : comment.getArticleId());
        comment.setAuthorId(sentComment.getAuthorId() != null ? sentComment.getAuthorId() : comment.getAuthorId());
        comment.setComment(sentComment.getComment() != null ? sentComment.getComment() : comment.getComment());

        comment.setUpdatedAt(new Date());

        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(String commentId) throws NotFoundExceptionHandler {
        return commentRepository.findById(commentId).orElseThrow(() -> new NotFoundExceptionHandler("No comment found with id: " + commentId));
    }

    @Override
    public void deleteComment(String commentId) {

        commentRepository.deleteById(commentId);

    }
}
