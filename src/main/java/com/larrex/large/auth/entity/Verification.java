package com.larrex.large.auth.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Verification {

    @Id
    private String id;
    private String email;
    private String token;
    private Date exp_date;

    private Date createdAt;


    private Date updatedAt;

}
