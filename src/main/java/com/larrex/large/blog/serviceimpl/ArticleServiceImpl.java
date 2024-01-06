package com.larrex.large.blog.serviceimpl;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.repository.ArticleRepository;
import com.larrex.large.blog.service.ArticleService;
import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article createBlog(Article article) {
        Date date = new Date();
        article.setCreatedAt(date);
        article.setUpdatedAt(date);
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article article, String articleId) throws NotFoundExceptionHandler {
//        private List<String> tags;


        Article databaseArticle = getArticleById(articleId);
        databaseArticle.setAuthorId(article.getAuthorId() != null ? article.getAuthorId() : databaseArticle.getAuthorId());
        databaseArticle.setTitle(article.getTitle() != null ? article.getCoverImageUrl() : databaseArticle.getTitle());
        databaseArticle.setSummary(article.getSummary() != null ? article.getSummary() : databaseArticle.getSummary());
        databaseArticle.setCoverImageUrl(article.getCoverImageUrl() != null ? article.getCoverImageUrl() : databaseArticle.getCoverImageUrl());
        databaseArticle.setCommentCount(article.getCommentCount() != null ? article.getCommentCount() : databaseArticle.getCommentCount());
        databaseArticle.setPrivateArticle(article.getPrivateArticle() != null ? article.getPrivateArticle() : databaseArticle.getPrivateArticle());
        databaseArticle.setUpdatedAt(new Date());


        databaseArticle.setUpdatedAt(new Date());
        return articleRepository.save(databaseArticle);

    }

    @Override
    public Article getArticleById(String articleId) throws NotFoundExceptionHandler {
        return articleRepository.findById(articleId).orElseThrow(() -> new NotFoundExceptionHandler("No article found with id: " + articleId));
    }

    @Override
    public Article getArticleByTile(String phrase) throws NotFoundExceptionHandler {
        return articleRepository.findByTitleContaining(phrase).orElseThrow(() -> new NotFoundExceptionHandler("No article found with phrase: " + phrase));

    }

    @Override
    public Article addTag(String articleId, String tag) throws NotFoundExceptionHandler {
        Article databaseArticle = getArticleById(articleId);

        if (databaseArticle.getTags() != null) {
            databaseArticle.getTags().add(tag);
        } else {
            ArrayList<String> tags = new ArrayList<>();
            tags.add(tag);
            databaseArticle.setTags(tags);
        }

        return articleRepository.save(databaseArticle);
    }

    @Override
    public Article removeTag(String articleId, String tag) throws NotFoundExceptionHandler {
        Article databaseArticle = getArticleById(articleId);
        if (databaseArticle.getTags() != null) {
            databaseArticle.getTags().remove(tag);
        } else {
            throw new NotFoundExceptionHandler("this article has no tags");
        }

        return articleRepository.save(databaseArticle);
    }

    @Override
    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }
}
