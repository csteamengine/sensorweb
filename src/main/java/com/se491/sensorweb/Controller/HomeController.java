package com.se491.sensorweb.Controller;

import com.se491.sensorweb.dto.NodeDataDto;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.Homenode.Homenode;
import com.se491.sensorweb.Service.EchoService;
import com.se491.sensorweb.Service.HomenodeService;
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
    private HomenodeService homenodeService;

    @Autowired
    private RouteService routeService;


    /**
     * Gets list of all home nodes.
     *
     * @return list of all home nodes
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/homenodes", produces = "application/json")
    public ResponseEntity getHomenodes() {
        List<Homenode> homenodes = this.homenodeService.getAllHomenodes();
        List<String> test = new ArrayList<>();
        test.add("Hello");
        test.add("Test");
        test.add("test again");


        return ResponseEntity.ok(homenodes);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/homenodes/{id}", produces = "application/json")
    public ResponseEntity getHomenode(@PathVariable("id") Long id) {
        Homenode homenode = this.homenodeService.getHomenode(id);
        if(homenode != null){
            return ResponseEntity.ok(homenode);
        }
        return ResponseEntity.ok(new Error("Cannot find homenode", id + ""));
    }

    /**
     * Adds a homenode to the database.
     *
     * @return the newly created homenode.
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/homenodes", produces = "application/json")
    public ResponseEntity addHomenode(@RequestBody Homenode homenode) {
        Homenode existing = homenodeService.getHomenodeByUnique(homenode.getUniqueId());
        if(existing == null){
            Homenode newHomenode = homenodeService.addHomenode(homenode);
            if(homenode != null){
                return ResponseEntity.ok(newHomenode);
            }
            return ResponseEntity.ok(new Error("Could not created new homenode", "Sorry"));
        }
        return ResponseEntity.ok(existing);
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
