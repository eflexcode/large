package com.larrex.large.user.service;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {


    User createUser(User user);

    User readUserById(String id) throws NotFoundExceptionHandler;

    User updateUser(User user,String userId) throws NotFoundExceptionHandler;
    User updateUserInterestsAdd(String userId,String keyword) throws NotFoundExceptionHandler;
    User updateUserInterestsRemove(String userId,String keyword) throws NotFoundExceptionHandler;
    User addBookmark(String userId,String postId) throws NotFoundExceptionHandler;
    User removeBookmark(String userId,String postId) throws NotFoundExceptionHandler;
    User follow(String userId,String userToFollowId) throws NotFoundExceptionHandler;
    User unfollow(String userId,String followingUserID) throws NotFoundExceptionHandler;
//    User updateUserFollowers(User user,Long userId) throws NotFoundExceptionHandler;
    User addUserArticleID(String userId,String myArticleId) throws NotFoundExceptionHandler;
    User removeUserArticleID(String userId,String myArticleId) throws NotFoundExceptionHandler;
    User uploadImage(MultipartFile multipartFile, String userId,Integer imagePosition ) throws IOException, NotFoundExceptionHandler;

    byte[] downloadImage(String filename);
    void deleteUser(String id);


}
