package com.larrex.large.blog.controller;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.service.ArticleService;
import com.larrex.large.blog.service.CommentService;
import com.larrex.large.exception.NotFoundExceptionHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    @PostMapping("/post")
   public Article createBlog(@RequestBody Article article){
      return   articleService.createBlog(article);
   }

   @PutMapping("/update/{articleId}")
   public Article update(@PathVariable String articleId,@RequestBody Article article) throws NotFoundExceptionHandler{
        return articleService.update(article,articleId);
   }

   @GetMapping("/get/{articleId}")
   public Article getArticleById(@PathVariable String articleId) throws NotFoundExceptionHandler{
        return articleService.getArticleById(articleId);
   }

   @GetMapping("/get/{phrase}")
   public Article getArticleByTile(@PathVariable String phrase) throws NotFoundExceptionHandler{
        return articleService.getArticleByTile(phrase);
   }

   @PutMapping("/update/addTag/{articleId}/{tag}")
   public Article addTag(@PathVariable String articleId,@PathVariable String tag) throws NotFoundExceptionHandler{
        return articleService.addTag(articleId, tag);
   }

    @PutMapping("/update/removeTag/{articleId}/{tag}")
   public Article removeTag(@PathVariable String articleId,@PathVariable String tag) throws NotFoundExceptionHandler{
        return articleService.removeTag(articleId, tag);
    }

    @DeleteMapping("/delete/{articleId}")
   public void deleteArticle(@PathVariable String articleId){
        articleService.deleteArticle(articleId);
   }

}
