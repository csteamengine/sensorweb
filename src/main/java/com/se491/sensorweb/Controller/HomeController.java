package com.se491.sensorweb.Controller;

import com.se491.sensorweb.Leafnode.Leafnode;
import com.se491.sensorweb.Reading.Reading;
import com.se491.sensorweb.Service.*;
import com.se491.sensorweb.dto.NodeDataDto;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.Homenode.Homenode;
import com.se491.sensorweb.error.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Node;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private HomenodeService homenodeService;

    @Autowired
    private LeafnodeService leafnodeService;

    @Autowired
    private ReadingService readingService;

    @Autowired
    private RouteService routeService;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/homenodes/{id}", produces = "application/json")
    public ResponseEntity getHomenode(@PathVariable("id") Long id) {
        Homenode homenode = this.homenodeService.getHomenode(id);
        if(homenode != null){
            return ResponseEntity.ok(homenode);
        }
        return ResponseEntity.ok(new Error("Cannot find homenode", id + ""));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/homenodes/{id}", produces = "application/json")
    public ResponseEntity postReadings(@PathVariable("id") String id, @RequestBody List<NodeDataDto> data) {
        //TODO loop through all the nodedatadtos and add the readings to the database for the given node
        Homenode homenode = homenodeService.getHomenodeByUnique(id);

        if(homenode == null){
            homenode = homenodeService.addHomenode(new Homenode(id, true));
        }

        for (NodeDataDto curr: data) {
            //TODO create a new reading with each curr
            Leafnode leafnode = leafnodeService.getLeafnodeFromHomenode(curr.getNodeId(), homenode.getId());
            if(leafnode == null){
                leafnode = leafnodeService.addLeafnode(new Leafnode(homenode.getId(), curr.getNodeId()));
            }
            Reading newReading = readingService.addReading(new Reading(leafnode.getId(), (long) 1, curr.getSensorReading(), true));
        }
        return ResponseEntity.ok(data);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/echo")
    public String loopback(@RequestBody NodeDataDto data){

        //We are expecting a java object with certain parameters
        EchoRequest request = new EchoRequest(true, "Parsed Data: \n"+data.toString());

        //Set our loopback utils last request
        echoService.addRequest(request);
        return request.toString();
    }



    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/echo")
    public String loopbackView(){
        return echoService.printRequests();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/{destination}/path")
    public int[] route(@PathVariable("destination") int destination){
        return routeService.getPathToDestination(destination);
    }

}
