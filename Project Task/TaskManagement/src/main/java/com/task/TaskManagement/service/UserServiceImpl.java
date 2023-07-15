package com.task.TaskManagement.service;

import com.task.TaskManagement.entity.User;
import com.task.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean checkId(int userId) {
        return userRepository.existsByUserid(userId  );
    }

    @Override
    public User Login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

}
