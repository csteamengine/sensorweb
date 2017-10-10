package com.se491.sensorweb.Reading;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="readings")
public class Reading {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long leafnodeId;

    private Long datatypeId;

    private String value;

    private boolean isActive;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    public Reading() {

    }

    public Reading(Long leafnodeId, Long datatypeId, String value, boolean isActive) {
        this.leafnodeId = leafnodeId;
        this.datatypeId = datatypeId;
        this.value = value;
        this.isActive = isActive;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
