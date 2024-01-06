package com.larrex.large.user.controller;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update/{userId}")
    public User updateUser(@PathVariable("userId") String userId, @RequestBody User sentUser) throws NotFoundExceptionHandler {
        return userService.updateUser(sentUser, userId);
    }

    @PostMapping("/bookmark/{userId}/{postId}")
    public User addBookmark(@PathVariable(name = "userId") String userId, @PathVariable(name = "postId") String postId) throws NotFoundExceptionHandler {
        return userService.addBookmark(userId, postId);
    }

    @DeleteMapping("/bookmark/{userId}/{postId}")
    public User removeBookmark(@PathVariable(name = "userId") String userId, @PathVariable(name = "postId") String postId) throws NotFoundExceptionHandler {
        return userService.removeBookmark(userId, postId);
    }

    @PutMapping("/addUserInterest/{userId}/{keyword}")
    User updateUserInterestsAdd(@PathVariable(name = "userId") String userId, @PathVariable(name = "keyword") String keyword) throws NotFoundExceptionHandler {
        return userService.updateUserInterestsAdd(userId, keyword);
    }

    @PutMapping("/removeUserInterest/{userId}/{keyword}")
    User updateUserInterestsRemove(@PathVariable(name = "userId") String userId, @PathVariable(name = "keyword") String keyword) throws NotFoundExceptionHandler {
        return userService.updateUserInterestsRemove(userId, keyword);
    }

    @PutMapping("/followAUser/{userId}/{userToFollowId}")
    User follow(@PathVariable(name = "userId") String userId, @PathVariable(name = "userToFollowId") String userToFollowId) throws NotFoundExceptionHandler {
        return userService.follow(userId, userToFollowId);
    }

    @PutMapping("/unfollowAUser/{userId}/{followingUserId}")
    User unfollow(@PathVariable(name = "userId") String userId,@PathVariable(name = "followingUserId") String followingUserID) throws NotFoundExceptionHandler {
        return userService.unfollow(userId, followingUserID);
    }

    @PutMapping("/addMyArticle/{userId}/{myArticleId}")
    User addUserArticleID(@PathVariable(name = "userId") String userId,@PathVariable(name = "myArticleId") String myArticleId) throws NotFoundExceptionHandler {
    return userService.addUserArticleID(userId, myArticleId);
    }

    @PutMapping("/removeMyArticle/{userId}/{myArticleId}")
    User removeUserArticleID(@PathVariable(name = "userId") String userId,@PathVariable(name = "myArticleId") String myArticleId) throws NotFoundExceptionHandler {
       return userService.removeUserArticleID(userId, myArticleId);
    }

    @PostMapping("/upload")
    public User uploadImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam(name = "userId") String id, @RequestParam(name = "imagePosition") Integer imagePosition) throws IOException, NotFoundExceptionHandler {
        return userService.uploadImage(multipartFile, id,imagePosition);
    }

    @GetMapping("/media/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable(name = "filename") String filename) throws IOException {
        return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body( userService.downloadImage(filename));
    }
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") String userId) throws NotFoundExceptionHandler {
        userService.deleteUser(userId);
    }
}
