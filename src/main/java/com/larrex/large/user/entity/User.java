package com.larrex.large.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.larrex.large.notification.entity.Notification;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String bio;
    private String location;
    private String profileImageUrl;
    private String coverImageUrl;
    private List<String> interests;
    private List<String> bookmarks;
    private List<String> followers;
    private List<String> following;
    private List<String> articleIDs;
    private List<Notification> notificationList; // save first 20 notification


    private Date createdAt;
    private Date updatedAt;


}
