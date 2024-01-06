package com.larrex.large.blog.service;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.exception.NotFoundExceptionHandler;

public interface ArticleService  {

    Article createBlog(Article article);
    Article update(Article article,String articleId) throws NotFoundExceptionHandler;
    Article getArticleById(String articleId) throws NotFoundExceptionHandler;
    Article getArticleByTile(String phrase) throws NotFoundExceptionHandler;
    void deleteArticle(String articleId);

}
