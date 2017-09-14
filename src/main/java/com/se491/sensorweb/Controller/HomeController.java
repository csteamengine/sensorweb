package com.se491.sensorweb.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.se491.sensorweb.Entity.EchoRequest;
import com.se491.sensorweb.HomeNode.HomeNode;
import com.se491.sensorweb.Service.EchoService;
import com.se491.sensorweb.Service.HomeNodeService;
import com.se491.sensorweb.Service.UserService;
import com.se491.sensorweb.User.User;
import com.se491.sensorweb.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.se491.sensorweb.error.Error;
import javax.xml.ws.Response;
import java.io.IOException;
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
        List<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/username/{username}", produces = "application/json")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username){
        User user = this.userService.getUserByUsername(username);

        if(user == null){
            Error error = new Error("Username Not Found", username);
            return ResponseEntity.ok(error);
        }

        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/email/{email}", produces = "application/json")
    public ResponseEntity getUserByEmail(@PathVariable("email") String email){
        User user = this.userService.getUserByEmail(email);

        if(user == null){
            Error error = new Error("No user with provided email", email);
            return ResponseEntity.ok(error);
        }

        return ResponseEntity.ok(user);
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
        if(user == null){
            Error error = new Error("User Not Found", id.toString());
            return ResponseEntity.ok(error);
        }
        return ResponseEntity.ok(user);
    }

    /**
     * Adds a new user
     *
     * @param user
     *
     * @return the user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users", produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user) {

        if(user.validate()){
            userService.addUser(user);
            return ResponseEntity.ok(user);
        }else{
            Error error = new Error("Incorrect Attributes Provided", "Check the specifications for how to format your requests.");
            return ResponseEntity.ok(error);
        }

    }

    /**
     * Edits an existing user.
     *
     * @param user
     *
     * @return the user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/{id}", produces = "application/json")
    public ResponseEntity editUser(@RequestBody User user) {
        if(user.getUserId() != null || !user.getUserId().equals("")){
            Error error = new Error("Incorrect Attributes Provided", "Make sure to user the correct endpoint to update a user.");
            return ResponseEntity.ok(error);
        }
        if(user.validate()){
            userService.updateUser(user);
            return ResponseEntity.ok(user);
        }else{
            Error error = new Error("Incorrect Attributes Provided", "Check the specifications for how to format your requests.");
            return ResponseEntity.ok(error);
        }

    }

    /**
     * Deletes an existing user.
     *
     * @param id
     *
     * @return the user
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        User deletedUser = userService.deleteUser(id);

        if(deletedUser == null){
            Error error = new Error("Error deleting user with provided userId", id.toString());
            return ResponseEntity.ok(error);
        }

        return ResponseEntity.ok(deletedUser);

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
