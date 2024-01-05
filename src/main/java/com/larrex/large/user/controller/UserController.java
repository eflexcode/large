package com.larrex.large.user.controller;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

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
       return userService.addUserArticleID(userId, myArticleId);
    }


    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") String userId) throws NotFoundExceptionHandler {
        userService.deleteUser(userId);
    }
}
