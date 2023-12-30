package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.Friend;

import java.util.List;

public interface FriendDao {
    /*增*/
    int insert(Friend friend);
    /*查找对应类型的医生*/
    List<Friend> getByType(String type);
    /*查找总数类型*/
    List<String> getTypeCount();
    /*根据id查找对应的医生*/
    Friend getById(int id);
    /*登录*/
    Friend login(String name,int password);
    /*更新信息*/
    int update(int id, String name,int password,String information);
}
