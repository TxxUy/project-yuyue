package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public User login(String username, String password) {
        String sql = "SELECT * FROM table_user WHERE UserName = ? AND PassWord = ?";
        List<User> users = this.jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("UserName"));
            user.setPassWord(resultSet.getString("PassWord"));
            user.setEmail(resultSet.getString("Email"));
            user.setAddress(resultSet.getString("Address"));
            user.setGender(resultSet.getString("Gender"));
            // 设置其他字段...
            return user;
        }, username, password);

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null; // 查询结果为空，返回空值
        }
    }
}
