package com.xyx.travelserver.service;

import com.xyx.travelserver.dao.AppointmentDao;
import com.xyx.travelserver.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentDao appointmentDao;
    @Override
    public int insert(Appointment appointment) {
        return appointmentDao.insert(appointment);
    }

    @Override
    public List<Appointment> getByUserId(int id) {
        return appointmentDao.getByUserId(id);
    }

    @Override
    public List<Appointment> getByFriendId(int id, Date date) {
        return appointmentDao.getByFriendId(id,date);
    }

    @Override
    public int deleteAppointment(int id) {
        return appointmentDao.deleteAppointment(id);
    }
}
