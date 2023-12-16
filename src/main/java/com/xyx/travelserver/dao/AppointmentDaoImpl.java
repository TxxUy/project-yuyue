package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public class AppointmentDaoImpl implements AppointmentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Appointment appointment) {
        String sql = "insert into table_user_friend(date,start_time,end_time,user_id,username,friend_id,friend_name) values(?,?,?,?,?,?,?)";
        return this.jdbcTemplate.update(sql,
                appointment.getDate(),
                appointment.getStart_time(),
                appointment.getEnd_time(),
                appointment.getUserid(),
                appointment.getUsername(),
                appointment.getFriendid(),
                appointment.getFriendname());
    }

    @Override
    public List<Appointment> getByUserId(int id) {
        String sql = "SELECT * FROM table_user_friend WHERE user_id = ?";
        return getAppointments(id, sql);
    }

    @Override
    public List<Appointment> getByFriendId(int id, Date date) {
        String sql = "SELECT * FROM table_user_friend WHERE friend_id = ? and date = ?";
        return getAppointmentsByDate(id, date, sql);
    }

    @Override
    public int deleteAppointment(int id) {
        String sql = "DELETE FROM table_user_friend WHERE id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    private List<Appointment> getAppointments(int id, String sql) {
        List<Appointment> appointments = this.jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Appointment appointment = new Appointment();
            appointment.setDate(rs.getDate("date"));
            appointment.setStart_time(rs.getString("start_time"));
            appointment.setEnd_time(rs.getString("end_time"));
            appointment.setId(rs.getInt("id"));
            appointment.setUserid(rs.getInt("user_id"));
            appointment.setUsername(rs.getString("username"));
            appointment.setFriendid(rs.getInt("friend_id"));
            appointment.setFriendname(rs.getString("friend_name"));
            return appointment;
        });
        return appointments;
    }
    private List<Appointment> getAppointmentsByDate(int id, Date date, String sql) {
        List<Appointment> appointments = this.jdbcTemplate.query(sql, new Object[]{id,date}, (rs, rowNum) -> {
            Appointment appointment = new Appointment();
            appointment.setDate(rs.getDate("date"));
            appointment.setStart_time(rs.getString("start_time"));
            appointment.setEnd_time(rs.getString("end_time"));
            appointment.setId(rs.getInt("id"));
            appointment.setUserid(rs.getInt("user_id"));
            appointment.setUsername(rs.getString("username"));
            appointment.setFriendid(rs.getInt("friend_id"));
            appointment.setFriendname(rs.getString("friend_name"));
            return appointment;
        });
        return appointments;
    }

}
