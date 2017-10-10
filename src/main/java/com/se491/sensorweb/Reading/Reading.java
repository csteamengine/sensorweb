package com.se491.sensorweb.Reading;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Reading {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long leafnodeId;

    private Long datatypeId;

    private String value;

    private boolean isActive;

    private String createdAt;

    private String updatedAt;

    public Reading() {

    }

    public Reading(Long leafnodeId, Long datatypeId, String value, boolean isActive, String createdAt, String updatedAt) {
        this.leafnodeId = leafnodeId;
        this.datatypeId = datatypeId;
        this.value = value;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeafnodeId() {
        return leafnodeId;
    }

    public void setLeafnodeId(Long leafnodeId) {
        this.leafnodeId = leafnodeId;
    }

    public Long getDatatypeId() {
        return datatypeId;
    }

    public void setDatatypeId(Long datatypeId) {
        this.datatypeId = datatypeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
