package com.larrex.large.blog.serviceimpl;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.repository.ArticleRepository;
import com.larrex.large.blog.service.ArticleService;
import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

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

        Article databaseArticle = getArticleById(articleId);
        databaseArticle.s(sentUser.getBio() != null ? sentUser.getBio() : databaseUser.getBio());
        databaseArticle.setEmail(sentUser.getEmail() != null ? sentUser.getEmail() : databaseUser.getEmail());
        databaseArticle.setName(sentUser.getName() != null ? sentUser.getName() : databaseUser.getName());
        databaseArticle.setCoverImageUrl(article.getCoverImageUrl() != null ? article.getCoverImageUrl() : databaseArticle.getCoverImageUrl());
        databaseArticle.setProfileImageUrl(sentUser.getProfileImageUrl() != null ? sentUser.getProfileImageUrl() : databaseUser.getProfileImageUrl());
        databaseArticle.setLocation(sentUser.getLocation() != null ? sentUser.getLocation() : databaseUser.getLocation());
        databaseArticle.setPassword(sentUser.getPassword() != null ? sentUser.getPassword() : databaseUser.getPassword());

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
    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }
}
