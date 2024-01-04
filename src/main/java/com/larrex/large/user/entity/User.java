package com.larrex.large.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String bio;
    private String location;
    private String profileImageUrl;
    private String coverImageUrl;
    private List<String> interests;
    private List<Long> bookmarks;
    private List<Long> followers;
    private List<Long> following;
    private List<Long> articleIDs;


    private Date createdAt;
    private Date updatedAt;


}
