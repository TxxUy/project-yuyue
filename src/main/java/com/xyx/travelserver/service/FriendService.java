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
}
