package com.larrex.large.user.serviceimpl;

import com.larrex.large.Util;
import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import com.larrex.large.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {


        Date date = new Date();
        user.setCreatedAt(date);
        user.setUpdatedAt(date);
        return userRepository.save(user);
    }

    @Override
    public User readUserById(String id) throws NotFoundExceptionHandler {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionHandler("No user found with id: " + id));
    }

    @Override
    public User updateUser(User sentUser, String userId) throws NotFoundExceptionHandler {

        User databaseUser = readUserById(userId);
        databaseUser.setBio(sentUser.getBio() != null ? sentUser.getBio() : databaseUser.getBio());
        databaseUser.setEmail(sentUser.getEmail() != null ? sentUser.getEmail() : databaseUser.getEmail());
        databaseUser.setName(sentUser.getName() != null ? sentUser.getName() : databaseUser.getName());
        databaseUser.setCoverImageUrl(sentUser.getCoverImageUrl() != null ? sentUser.getCoverImageUrl() : databaseUser.getCoverImageUrl());
        databaseUser.setProfileImageUrl(sentUser.getProfileImageUrl() != null ? sentUser.getProfileImageUrl() : databaseUser.getProfileImageUrl());
        databaseUser.setLocation(sentUser.getLocation() != null ? sentUser.getLocation() : databaseUser.getLocation());
        databaseUser.setPassword(sentUser.getPassword() != null ? sentUser.getPassword() : databaseUser.getPassword());

        databaseUser.setUpdatedAt(new Date());
        return userRepository.save(databaseUser);
    }

    @Override
    public User updateUserInterestsAdd(String userId, String keyword) throws NotFoundExceptionHandler {

        User databaseUser = readUserById(userId);

        if (databaseUser.getInterests() != null) {
            databaseUser.getInterests().add(keyword);
        } else {
            ArrayList<String> interests = new ArrayList<>();
            interests.add(keyword);
            databaseUser.setInterests(interests);
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User updateUserInterestsRemove(String userId, String keyword) throws NotFoundExceptionHandler {
        User databaseUser = readUserById(userId);
        if (databaseUser.getInterests() != null) {
            databaseUser.getInterests().remove(keyword);
        } else {
            throw new NotFoundExceptionHandler("User has no bookmarks");
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User addBookmark(String userId, String postId) throws NotFoundExceptionHandler {
        User databaseUser = readUserById(userId);

        if (databaseUser.getBookmarks() != null) {
            databaseUser.getBookmarks().add(postId);
        } else {
            ArrayList<String> bookmarks = new ArrayList<>();
            bookmarks.add(postId);
            databaseUser.setBookmarks(bookmarks);
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User removeBookmark(String userId, String postId) throws NotFoundExceptionHandler {

        User databaseUser = readUserById(userId);
        if (databaseUser.getBookmarks() != null) {
            databaseUser.getBookmarks().remove(postId);
        } else {
            throw new NotFoundExceptionHandler("User has no bookmarks");
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User follow(String userId, String userToFollowId) throws NotFoundExceptionHandler {
        User me = readUserById(userId);
        User toFollow = readUserById(userToFollowId);

        if (me.getFollowing() != null) {
            me.getFollowing().add(userToFollowId);
        } else {
            ArrayList<String> followers = new ArrayList<>();
            followers.add(userToFollowId);
            me.setFollowing(followers);
        }


        if (toFollow.getFollowing() != null) {
            toFollow.getFollowing().add(userId);
        } else {
            ArrayList<String> followers = new ArrayList<>();
            followers.add(userId);
            toFollow.setFollowing(followers);
        }
        userRepository.save(toFollow);
        return userRepository.save(me);
    }

    @Override
    public User unfollow(String userId, String followingUserID) throws NotFoundExceptionHandler {

        User me = readUserById(userId);
        User toUnfollow = readUserById(followingUserID);
        if (me.getFollowing() != null) {
            me.getFollowing().remove(followingUserID);
        } else {
            throw new NotFoundExceptionHandler("User is not following u");
        }
        if (toUnfollow.getFollowers() != null) {
            toUnfollow.getFollowers().remove(userId);
        } else {
            throw new NotFoundExceptionHandler("User is not following u");
        }
        userRepository.save(toUnfollow);
        return userRepository.save(me);
    }

    @Override
    public User addUserArticleID(String userId, String myArticleId) throws NotFoundExceptionHandler {

        User databaseUser = readUserById(userId);

        if (databaseUser.getArticleIDs() != null) {
            databaseUser.getInterests().add(myArticleId);
        } else {
            ArrayList<String> myArticle = new ArrayList<>();
            myArticle.add(myArticleId);
            databaseUser.setBookmarks(myArticle);
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User removeUserArticleID(String userId, String myArticleId) throws NotFoundExceptionHandler {
        User databaseUser = readUserById(userId);
        if (databaseUser.getArticleIDs() != null) {
            databaseUser.getInterests().remove(myArticleId);
        } else {
            throw new NotFoundExceptionHandler("Article does not exist");
        }

        return userRepository.save(databaseUser);
    }

    @Override
    public User uploadImage(MultipartFile multipartFile, String userId, Integer imagePosition) throws IOException, NotFoundExceptionHandler {

        String imageName =  Util.createFile(multipartFile);

        User user = new User();
        if (imagePosition == 1){
            user.setProfileImageUrl(Util.downloadUniversalPath+imageName);
        }else if (imagePosition == 2){
            user.setCoverImageUrl(Util.downloadUniversalPath+imageName);
        }

        return updateUser(user,userId);
    }

    @Override
    public byte[] downloadImage(String filename) {
        return Util.downloadImage(filename);
    }


    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
