package com.xyx.travelserver.service;

import com.xyx.travelserver.dao.UserDao;
import com.xyx.travelserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public int login(String username, String password) {
        return userDao.login(username,password);
    }
}
