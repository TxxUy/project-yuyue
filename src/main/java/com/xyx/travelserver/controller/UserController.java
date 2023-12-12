package com.xyx.travelserver.controller;

import com.xyx.travelserver.entity.User;
import com.xyx.travelserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 服务器实现新增用户
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public User save(String username,String password,String email,String address,String gender){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setAddress(address);
        user.setGender(gender);
        int result = this.userService.insert(user);
        System.out.println(result);
        return user;
    }
    /**
     * 服务器实现查询用户功能
     */
    @RequestMapping("/getByUserName")
    @ResponseBody
    public User getByUserName(String username){
        User user = this.userService.getByUserName(username);
        System.out.println(user.getUserName());
        return user;
    }
    /**
     * 服务器实现登录功能
     */
    @RequestMapping("/login")
    @ResponseBody
    public int login(String username,String password){
        return this.userService.login(username,password);
    }
}
