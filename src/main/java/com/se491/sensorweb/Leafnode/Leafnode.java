package com.se491.sensorweb.Leafnode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="leafnodes")
public class Leafnode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long homenodeId;

    private float latitude;

    private float longitude;

    @Basic(optional = false)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    private boolean isActive;

    public Leafnode() {

    }

    public Leafnode(Long homenodeId, float latitude, float longitude, boolean isActive) {
        this.homenodeId = homenodeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHomenodeId() {
        return homenodeId;
    }

    public void setHomenodeId(Long homeNodeId) {
        this.homenodeId = homeNodeId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
