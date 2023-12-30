package com.xyx.travelserver.entity;

public class Friend {
    private int id;
    private String friend_name;
    private String friend_type;
    private String friend_information;
    private int password;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    private String base64;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Friend(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getFriend_type() {
        return friend_type;
    }

    public void setFriend_type(String friend_type) {
        this.friend_type = friend_type;
    }

    public String getFriend_information() {
        return friend_information;
    }

    public void setFriend_information(String friend_information) {
        this.friend_information = friend_information;
    }
}
