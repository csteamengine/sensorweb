package com.se491.sensorweb.Homenode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "homenodes")
public class Homenode {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String uniqueId;

    private float longitude;

    private float latitude;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    private boolean isActive;

    public Homenode() {

    }

    public Homenode(String uniqueId, float longitude, boolean isActive) {
        this.uniqueId = uniqueId;
        this.longitude = longitude;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
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
