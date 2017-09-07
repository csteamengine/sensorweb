package com.se491.sensorweb.HomeNode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class HomeNode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer homeNodeId;

    private Integer userId;

    private boolean isActive;

    private String dateCreated;

    private String nickName;

    public Integer getHomeNodeId() {
        return homeNodeId;
    }

    public void setHomeNodeId(Integer homeNodeId) {
        this.homeNodeId = homeNodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
