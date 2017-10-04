package com.se491.sensorweb.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeDataDto {

    @JsonProperty("id")
    private int nodeId;
    @JsonProperty("value")
    private double sensorReading;

    public int getNodeId() {
        return nodeId;
    }


    public void setNodeId(int nodeId) {
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
