package com.larrex.large.user.serviceimpl;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import com.larrex.large.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return null;
    }

    @Override
    public User updateUserInterestsRemove(String userId, Long listIndex) throws NotFoundExceptionHandler {
        return null;
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
    public User updateUserFollowing(String userId, String userToFollowId) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public User unfollow(String userId, String followingUserID) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public User updateUserArticleID(String userId, String myArticleId) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
