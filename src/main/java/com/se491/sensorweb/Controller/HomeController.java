package com.se491.sensorweb.Controller;

import com.se491.sensorweb.DTO.NodeDataDto;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.HomeNode.HomeNode;
import com.se491.sensorweb.Service.EchoService;
import com.se491.sensorweb.Service.HomeNodeService;
import com.se491.sensorweb.Service.UserService;
import com.se491.sensorweb.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private UserService userService;

    @Autowired
    private HomeNodeService homeNodeService;

    /**
     *
     * Gets list of all users.
     *
     * @return list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = "application/json")
    public ResponseEntity getUsers(){
        //TODO get all users into json.
        List<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    /**
     *
     * Gets list of all home nodes.
     *
     * @return list of all home nodes
     */
    @RequestMapping(method = RequestMethod.GET, value = "/homenodes", produces = "application/json")
    public ResponseEntity getHomeNodes(){
        //TODO get all users into json.
        List<HomeNode> homeNodes = this.homeNodeService.getAllHomeNodes();

        return ResponseEntity.ok(homeNodes);
    }

    /**
     * Gets user by id
     *
     * @param id gets the user by id
     *
     * @return the user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") Long id) {

        User user = this.userService.getUserById(id);

        return ResponseEntity.ok(user);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/echo")
    public String loopback(@RequestBody NodeDataDto data){

        //We are expecting a java object with the
        EchoRequest request = new EchoRequest(true, "Parsed Data: \n"+data.toString());

        //Set our loopback utils last request
        echoService.addRequest(request);
        return request.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value="/echo")
    public String loopbackView(){
        return echoService.printRequests();
    }

}
