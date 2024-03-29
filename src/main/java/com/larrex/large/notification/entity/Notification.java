package com.larrex.large.notification.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Notification {

    @Id
    private String id;
    private String articleId;
    private String authorId;
    private String commenterId;
    private String message;
    private Date createdAt;
    private Boolean isRead = false;

}
