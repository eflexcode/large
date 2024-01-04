package com.larrex.large.user.service;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;

import java.util.List;

public interface UserService {


    User createUser(User user);

    User readUserById(Long id) throws NotFoundExceptionHandler;

    User updateUser(User user,Long userId) throws NotFoundExceptionHandler;
    User updateUserInterestsAdd(Long userId,String keyword) throws NotFoundExceptionHandler;
    User updateUserInterestsRemove(Long userId,Long listIndex) throws NotFoundExceptionHandler;
    User addBookmark(Long userId,Long postId) throws NotFoundExceptionHandler;
    User removeBookmark(Long userId,Long postId) throws NotFoundExceptionHandler;
    User updateUserFollowing(Long userId,Long userToFollowId) throws NotFoundExceptionHandler;
    User unfollow(Long userId,Long followingUserID) throws NotFoundExceptionHandler;
//    User updateUserFollowers(User user,Long userId) throws NotFoundExceptionHandler;
    User updateUserArticleID(Long userId,Long myArticleId) throws NotFoundExceptionHandler;

    void deleteUser(Long id);


}
