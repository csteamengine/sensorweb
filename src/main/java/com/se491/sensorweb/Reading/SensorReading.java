package com.se491.sensorweb.Reading;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class SensorReading {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer sensorReadingId;

    private Integer leafNodeId;

    private Integer homeNodeId;

    private float readingValue;

    private boolean isActive;

    private String dateCreated;

    public Integer getSensorReadingId() {
        return sensorReadingId;
    }

    public void setSensorReadingId(Integer sensorReadingId) {
        this.sensorReadingId = sensorReadingId;
    }

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

    public float getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(float readingValue) {
        this.readingValue = readingValue;
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
}
