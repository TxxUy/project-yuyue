package com.xyx.travelserver.service;

import com.xyx.travelserver.entity.User;

public interface UserService {
    int insert(User user);
    User getByUserName(String username);
    User login (String username,String password);
}
