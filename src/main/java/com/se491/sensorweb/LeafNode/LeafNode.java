package com.se491.sensorweb.LeafNode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class LeafNode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer leafNodeId;

    private Integer homeNodeId;

    private Integer userId;

    private String dateCreated;

    private boolean isActive;

    public Integer getLeafNodeId() {
        return leafNodeId;
    }

    public void setLeafNodeId(Integer leafNodeId) {
        this.leafNodeId = leafNodeId;
    }

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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
