package com.larrex.large.blog.service;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;

public interface ArticleService  {

    Article createBlog(Article article);
    Article update(Article article,String articleId) throws NotFoundExceptionHandler;
    Article getArticleById(String articleId) throws NotFoundExceptionHandler;
    Article getArticleByTile(String phrase) throws NotFoundExceptionHandler;

    Article addTag(String articleId,String tag) throws NotFoundExceptionHandler;
    Article removeTag(String articleId,String tag) throws NotFoundExceptionHandler;
    void deleteArticle(String articleId);

}
