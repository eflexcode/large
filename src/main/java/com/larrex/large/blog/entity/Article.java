package com.larrex.large.blog.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Article {

    @Id
    private String id;
    private String authorId;

    private String title;
    private String content;
    private String summary;
    private String coverImageUrl;
    private List<String> tags;
    private Long commentCount;
    private Long likeCount;
    private List<String> likeUserIds;
    private Boolean privateArticle;

    private Date createdAt;
    private Date updatedAt;

}
