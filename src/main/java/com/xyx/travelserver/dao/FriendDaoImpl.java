package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class FriendDaoImpl implements FriendDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Friend friend) {
        String sql = "insert into table_friend(friendname,friendtype,friendinformation) values(?,?,?)";
        return this.jdbcTemplate.update(
                sql,
                friend.getFriend_name(),
                friend.getFriend_type(),
                friend.getFriend_information(),
                friend.getPassword()
        );
    }

    @Override
    public List<Friend> getByType(String type) {
        String sql = "SELECT * FROM table_friend WHERE friendtype = ?";
        System.out.println(type);
        List<Friend> friends = this.jdbcTemplate.query(sql, new Object[]{type}, (rs, rowNum) -> {
            Friend friend = new Friend();
            friend.setId(Integer.parseInt(rs.getString("id")));
            friend.setFriend_name(rs.getString("friendname"));
            friend.setFriend_type(rs.getString("friendtype"));
            friend.setFriend_information(rs.getString("friendinformation"));
            return friend;
        });

        return friends;
    }

    @Override
    public List<String> getTypeCount() {
        String sql = "SELECT DISTINCT friendtype FROM table_friend";
        List<String> typeList = jdbcTemplate.queryForList(sql, String.class);
        return typeList;
    }

    @Override
    public Friend getById(int id) {
        String sql = "SELECT * FROM table_friend WHERE id = ?";
        Friend friend = jdbcTemplate.queryForObject(sql, new RowMapper<Friend>() {
            @Override
            public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
                Friend friend = new Friend();
                friend.setId(rs.getInt("id"));
                friend.setFriend_name(rs.getString("friendname"));
                friend.setFriend_type(rs.getString("friendtype"));
                friend.setFriend_information(rs.getString("friendinformation"));
                friend.setPassword(rs.getInt("password"));
                friend.setBase64(rs.getString("photo"));
                return friend;
            }
        },id);
        return friend;
    }

    @Override
    public Friend login(String name, int password) {
        String sql = "SELECT * FROM table_friend WHERE friendname = ? AND PassWord = ?";
        List<Friend> friends = this.jdbcTemplate.query(sql, (resultSet, i) -> {
            Friend user = new Friend();
            user.setId(resultSet.getInt("id"));
            user.setFriend_name(resultSet.getString("FriendName"));
            user.setPassword(resultSet.getInt("PassWord"));
            user.setFriend_information(resultSet.getString("friendinformation"));
            user.setFriend_type(resultSet.getString("friendtype"));
            user.setBase64(resultSet.getString("photo"));
            // 设置其他字段...
            return user;
        }, name, password);

        if (!friends.isEmpty()) {
            return friends.get(0);
        } else {
            return null; // 查询结果为空，返回空值
        }
    }

    @Override
    public int update(int id, String name,int password,String information) {
        String sql = "update table_friend set friendname = ?, friendinformation = ? ,password = ? where id = ?";
        return this.jdbcTemplate.update(
                sql,
                name,
                information,
                password,
                id
        );
    }
}
