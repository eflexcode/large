package com.larrex.large.blog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long authorId;

    private String title;
    private String content;
    private String summary;
    private String coverImageUrl;
    private List<String> tags;
    private Long commentCount;

    private Date createdAt;
    private Date updatedAt;

}
