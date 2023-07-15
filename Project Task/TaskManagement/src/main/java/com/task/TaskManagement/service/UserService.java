package com.task.TaskManagement.service;

import com.task.TaskManagement.entity.User;


public interface UserService {

    public User createUser(User user);

    public boolean checkEmail(String email);

    public boolean checkId(int userId);

    public User Login(String username, String password);

}

