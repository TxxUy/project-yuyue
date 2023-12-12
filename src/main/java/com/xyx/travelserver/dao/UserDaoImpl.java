package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(User user) {
        String sql = "insert into table_user(username,password,email,address,gender) values(?,?,?,?,?)";
        return this.jdbcTemplate.update(
                sql,
                user.getUserName(),
                user.getPassWord(),
                user.getEmail(),
                user.getAddress(),
                user.getGender()
        );
    }

    @Override
    public User getByUserName(String username) {
        String sql = "select * from table_user where UserName = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("UserName"));
                user.setPassWord(rs.getString("PassWord"));
                return user;
            }
        },username);
    }

    @Override
    public int login(String username, String password) {
        String sql = "select count(*) from table_user where UserName=? and PassWord=?";
        Integer count = this.jdbcTemplate.queryForObject(sql, Integer.class, username, password);
        return (count != null && count > 0) ? 1 : 0;
    }
}
