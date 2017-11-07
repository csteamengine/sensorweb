package com.se491.sensorweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeDataDto {

    @JsonProperty("id")
    private Long nodeId;
    @JsonProperty("value")
    private double sensorReading;

    public Long getNodeId() {
        return nodeId;
    }


    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public double getSensorReading() {
        return sensorReading;
    }

    public void setSensorReading(double sensorReading) {
        this.sensorReading = sensorReading;
    }

    @Override
    public String toString() {
        return "NodeDataDto{" +
                "nodeId=" + nodeId +
                ", sensorReading=" + sensorReading +
                '}';
    }


}
