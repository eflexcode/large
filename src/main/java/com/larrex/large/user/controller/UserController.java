package com.larrex.large.user.controller;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @PostMapping("/bookmark/{userId}/{postId}")
    public User addBookmark(@PathVariable(name = "userId") String userId,@PathVariable(name = "postId") String postId) throws NotFoundExceptionHandler {
        return userService.addBookmark(userId, postId);
    }
    @DeleteMapping("/bookmark/{userId}/{postId}")
    public User removeBookmark(@PathVariable(name = "userId") String userId,@PathVariable(name = "postId") String postId) throws NotFoundExceptionHandler {
        return userService.removeBookmark(userId, postId);
    }


}
