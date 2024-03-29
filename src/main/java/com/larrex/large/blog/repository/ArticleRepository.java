package com.larrex.large.blog.repository;

import com.larrex.large.blog.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends MongoRepository<Article,String> {

    Optional<Article> findByTitleContaining(String title);
}
