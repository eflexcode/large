package com.larrex.large.blog.repository;

import com.larrex.large.blog.entity.Article;
import com.larrex.large.blog.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
}
