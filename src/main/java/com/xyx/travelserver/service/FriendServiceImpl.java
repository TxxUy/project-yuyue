package com.xyx.travelserver.service;

import com.xyx.travelserver.dao.FriendDao;
import com.xyx.travelserver.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;
    @Override
    public int insert(Friend friend) {
        return friendDao.insert(friend);
    }

    @Override
    public List<Friend> getByType(String type) {
        return friendDao.getByType(type);
    }

    @Override
    public List<String> getTypeCount() {
        return friendDao.getTypeCount();
    }

    @Override
    public Friend getById(int id) {
        return friendDao.getById(id);
    }
}
