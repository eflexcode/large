package com.larrex.large.user.serviceimpl;

import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import com.larrex.large.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User readUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

}
