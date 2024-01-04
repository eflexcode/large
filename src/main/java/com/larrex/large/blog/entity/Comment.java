package com.larrex.large.blog.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Comment {

    @Id
    private String id;
    private String articleId;
    private String authorId; // owner of comment
    private String comment;

    private Date createdAt;
    private Date updatedAt;

}
