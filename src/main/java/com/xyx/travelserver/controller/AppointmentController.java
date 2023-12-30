package com.xyx.travelserver.controller;

import com.xyx.travelserver.entity.Appointment;
import com.xyx.travelserver.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 服务器增加预约记录请求
     * @param date
     * @param start_time
     * @param end_time
     * @param user_id
     * @param username
     * @param friend_id
     * @param friend_name
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    private Appointment save(Date date,String start_time,String end_time,int user_id,String username,int friend_id,String friend_name){
        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setStart_time(start_time);
        appointment.setEnd_time(end_time);
        appointment.setUserid(user_id);
        appointment.setUsername(username);
        appointment.setFriendid(friend_id);
        appointment.setFriendname(friend_name);
        int result = this.appointmentService.insert(appointment);
        return appointment;
    }

    /**
     * 服务器查询用户预约记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getByUserId")
    private List<Appointment> getByUserId(int id){
        System.out.println(id);
        return this.appointmentService.getByUserId(id);
    }

    /**
     * 服务器根据id和日期查找对应医生的预约记录
     * @param id
     * @param date
     * @return
     */
    @ResponseBody
    @RequestMapping("/getByFriendId")
    private List<Appointment> getByFriendId(int id,Date date){
        return this.appointmentService.getByFriendId(id,date);
    }

    /**
     * 删除对应的预约记录
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteAppointment")
    private int deleteAppointment(int id){
        System.out.println(id);
        return this.appointmentService.deleteAppointment(id);
    }
}
