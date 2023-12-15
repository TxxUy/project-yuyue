package com.xyx.travelserver.dao;

import com.xyx.travelserver.entity.Friend;
import com.xyx.travelserver.entity.User;
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
                friend.getFriend_information()
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

        // 输出查询结果
        for (Friend friend : friends) {
            System.out.println(friend.toString()); // 或使用日志记录库进行记录
        }

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
        System.out.println(id);
        String sql = "SELECT * FROM table_friend WHERE id = ?";
        Friend friend = jdbcTemplate.queryForObject(sql, new RowMapper<Friend>() {
            @Override
            public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
                Friend friend = new Friend();
                friend.setId(rs.getInt("id"));
                friend.setFriend_name(rs.getString("friendname"));
                friend.setFriend_type(rs.getString("friendtype"));
                friend.setFriend_information(rs.getString("friendinformation"));
                friend.setBase64(rs.getString("photo"));
                return friend;
            }
        },id);
        System.out.println(friend.getBase64());
        return friend;
    }
}
