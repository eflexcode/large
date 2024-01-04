package com.larrex.large.user.service;

import com.larrex.large.user.entity.User;

public interface UserService {

    User createUser(User user);

    User readUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);


}
