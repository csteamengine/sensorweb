package com.se491.sensorweb.Service;

import org.springframework.stereotype.Service;

@Service
public class RouteService {

    public int[] getPathToDestination(int destination){

        return new int[]{0,1,2};
    }
}
