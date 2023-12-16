package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.Appointment;

import java.sql.Date;
import java.util.List;

public interface AppointmentDao {
    /*增加预约记录*/
    int insert(Appointment appointment);
    /*查询使用者的预约记录*/
    List<Appointment> getByUserId(int id);
    /*查询对应医生以及对应时间的已有预约记录*/
    List<Appointment> getByFriendId(int id, Date date);
    /*删除对应的预约记录*/
    int deleteAppointment(int id);
}
