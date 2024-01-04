package com.larrex.large.user.service;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;

import java.util.List;

public interface UserService {


    User createUser(User user);

    User readUserById(String id) throws NotFoundExceptionHandler;

    User updateUser(User user,String userId) throws NotFoundExceptionHandler;
    User updateUserInterestsAdd(String userId,String keyword) throws NotFoundExceptionHandler;
    User updateUserInterestsRemove(String userId,Long listIndex) throws NotFoundExceptionHandler;
    User addBookmark(String userId,String postId) throws NotFoundExceptionHandler;
    User removeBookmark(String userId,String postId) throws NotFoundExceptionHandler;
    User updateUserFollowing(String userId,String userToFollowId) throws NotFoundExceptionHandler;
    User unfollow(String userId,String followingUserID) throws NotFoundExceptionHandler;
//    User updateUserFollowers(User user,Long userId) throws NotFoundExceptionHandler;
    User updateUserArticleID(String userId,String myArticleId) throws NotFoundExceptionHandler;

    void deleteUser(String id);


}
