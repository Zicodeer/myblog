package com.zjh.service;

import com.zjh.dao.UserRepositor;
import com.zjh.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositor userRepositor;

    @Override
    public User checkUser(String username, String password) {

        User user = userRepositor.findByUsernameAndPassword(username, password);

        return user;
    }
}
