package com.xyx.travelserver.service;

import com.xyx.travelserver.entity.Friend;

import java.util.List;

public interface FriendService {
    /*增*/
    int insert(Friend friend);
    /*查找对应类型的医生*/
    List<Friend> getByType(String type);
    /*查找医生中所有类型*/
    List<String> getTypeCount();
    /*根据id查找对应的医生*/
    Friend getById(int id);
    /*医生登录*/
    Friend login(String name,int password);
    /*根据id更新对应医生的信息*/
    int update(int id, String name,int password,String information);
}
