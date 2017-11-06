package com.se491.sensorweb;


import com.se491.sensorweb.Service.RouteService;
import org.junit.Test;

public class RouteTests {

    @Test
    public void testFloydWarshall(){
        RouteService.calculatePathsForGraph();
    }
}
