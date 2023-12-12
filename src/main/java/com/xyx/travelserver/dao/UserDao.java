package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.User;

public interface UserDao {
    /*增*/
    int insert(User user);
    /*查找*/
    User getByUserName(String username);
    /*登录*/
    int login(String username,String password);
}
