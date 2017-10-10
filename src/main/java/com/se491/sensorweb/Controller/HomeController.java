package com.se491.sensorweb.Controller;

import com.se491.sensorweb.dto.NodeDataDto;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.HomeNode.HomeNode;
import com.se491.sensorweb.Service.EchoService;
import com.se491.sensorweb.Service.HomeNodeService;
import com.se491.sensorweb.Service.RouteService;
import com.se491.sensorweb.error.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private HomeNodeService homeNodeService;

    @Autowired
    private RouteService routeService;


    /**
     * Gets list of all home nodes.
     *
     * @return list of all home nodes
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/homeNodes", produces = "application/json")
    public ResponseEntity getHomeNodes() {
        //TODO get all users into json.
        List<HomeNode> homeNodes = this.homeNodeService.getAllHomeNodes();
        List<String> test = new ArrayList<>();
        test.add("Hello");
        test.add("Test");
        test.add("test again");


        return ResponseEntity.ok(homeNodes);
    }


    /**
     * Gets list of all home nodes.
     *
     * @return list of all home nodes
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/homeNodes/{id}", produces = "application/json")
    public ResponseEntity getHomeNode(@PathVariable("id") Long id) {
        //TODO get all users into json.
        HomeNode homeNode = this.homeNodeService.getHomeNode(id);
        if(homeNode != null){
            return ResponseEntity.ok(homeNode);
        }
        return ResponseEntity.ok(new Error("Cannot find homenode", id + ""));
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
