package com.se491.sensorweb.LeafNode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class LeafNode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long homeNodeId;

    private float latitude;

    private float longitude;

    private String createdAt;

    private String updatedAt;

    private boolean isActive;

    public LeafNode() {

    }

    public LeafNode(Long homeNodeId, float latitude, float longitude, String createdAt, String updatedAt, boolean isActive) {
        this.homeNodeId = homeNodeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHomeNodeId() {
        return homeNodeId;
    }

    public void setHomeNodeId(Long homeNodeId) {
        this.homeNodeId = homeNodeId;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
