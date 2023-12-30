package com.xyx.travelserver.controller;

import com.xyx.travelserver.entity.Friend;
import com.xyx.travelserver.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;
    /**
     * 服务器新增朋友
     */
    @RequestMapping("/save")
    @ResponseBody
    private Friend save(String friend_name,String friend_type,String friend_information){
        Friend friend = new Friend();
        friend.setFriend_name(friend_name);
        friend.setFriend_type(friend_type);
        friend.setFriend_information(friend_information);
        int result = this.friendService.insert(friend);
        System.out.println("新增结果："+result);
        return friend;
    }

    /**
     * 获取某一类型的所有医生数据
     * @param type
     * @return
     */
    @RequestMapping("/getByType")
    @ResponseBody
    private List<Friend> getByType(String type){
        System.out.println(this.friendService.getByType(type));
        return this.friendService.getByType(type);
    }

    /**
     * 获取医院中所有医类
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTypeCount")
    private List<String> getTypeCount(){
        return this.friendService.getTypeCount();
    }

    /**
     * 根据id获取专家
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getById")
    private Friend getById(int id){
        return this.friendService.getById(id);
    }

    /**
     * 专家登录
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    private Friend login(String name,int password){
        return this.friendService.login(name,password);
    }

    /**
     * 专家更新自己的个人信息
     * @param id
     * @param name
     * @param password
     * @param information
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    private int update(int id,String name,int password, String information){
        return this.friendService.update(id,name,password,information);
    }
}
