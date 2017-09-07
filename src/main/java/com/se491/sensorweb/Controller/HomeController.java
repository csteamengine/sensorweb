package com.se491.sensorweb.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.Service.EchoService;
import com.se491.sensorweb.Service.UserService;
import com.se491.sensorweb.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class HomeController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private UserService userService;

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


    @RequestMapping("/echo")
    public String loopback(@RequestParam String data){
        boolean isValidJson;
        //Try to parse the "json", return false if we cant (meaning the json is invalid).
        try{
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(data);
            isValidJson = true;

        } catch (IOException e) {
            isValidJson = false;
        }
        //Return if the string is valid, and the text
        EchoRequest request = new EchoRequest(isValidJson, data);

        //Set our loopback utils last request
        echoService.addRequest(request);
        return request.toString();
    }

    @RequestMapping("/echo/view")
    public String loopbackView(){
        return echoService.printRequests();
    }

//    @RequestMapping("/")
//    public String hello(){
//        return "ayy";
//    }
}
