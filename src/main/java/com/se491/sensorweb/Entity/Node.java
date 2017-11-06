package com.se491.sensorweb.Entity;

import java.util.List;

public class Node {

    private int id;
    private List<Integer> adjacencies;
    
    public Node (int id, List adjacencies){
        this.id = id;
        this.adjacencies = adjacencies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Integer> adjacencies) {
        this.adjacencies = adjacencies;
    }
}
