package com.se491.sensorweb.Controller;

import com.se491.sensorweb.DTO.NodeDataDto;
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
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = "application/json")
    public ResponseEntity getUsers(){
        List<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/users/username/{username}", produces = "application/json")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username){
        User user = this.userService.getUserByUsername(username);

        if(user == null){
            Error error = new Error("Username Not Found", username);
            return ResponseEntity.ok(error);
        }

        return ResponseEntity.ok(user);
    }

    /**
     * Checks a users password
     *
     * @param user
     *
     * @return the user
     */
    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(method = RequestMethod.POST, value = "/users/login", produces = "application/json")
    public ResponseEntity loginUser(@RequestBody User user) throws Exception {
        if(user.validate()){
            User foundUser = userService.getUserByUsername(user.getUsername());
            if(foundUser == null){
                foundUser = userService.getUserByEmail(user.getUsername());
                if(foundUser == null){
                    Error error = new Error("222", "Incorrect Username or Password");
                    return ResponseEntity.ok(error);
                }
            }

            if(foundUser.checkPassword(user.getPassword())){

                return ResponseEntity.ok(user);
            }else{
                Error error = new Error("222", "Incorrect Username or Password");
                return ResponseEntity.ok(error);
            }

        }else{
            Error error = new Error("222", "Check the specifications for how to format your requests.");
            return ResponseEntity.ok(error);
        }

    }


    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:63343")
    @RequestMapping(method = RequestMethod.POST, value = "/users", produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user) throws Exception {
        if(user.validate()){
            User foundUser = userService.getUserByUsername(user.getUsername());
            if(foundUser == null){
                user.hashPassword();
                userService.addUser(user);
                return ResponseEntity.ok(user);
            }
            Error error = new Error("222", "Username already taken");
            return ResponseEntity.ok(error);
        }else{
            Error error = new Error("222", "Check the specifications for how to format your requests.");
            return ResponseEntity.ok(error);
        }


        /**
         * Edits an existing user.
         *
         * @param user
         *
         * @return the user
         */
        @CrossOrigin(origins = "http://localhost:3000")
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
        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}", produces = "application/json")
        public ResponseEntity deleteUser(@PathVariable("id") Long id) {
            User deletedUser = userService.deleteUser(id);

            if(deletedUser == null){
                Error error = new Error("Error deleting user with provided userId", id.toString());
                return ResponseEntity.ok(error);
            }

            return ResponseEntity.ok(deletedUser);

            @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/echo")
    public String loopback(@RequestBody NodeDataDto data){

        //We are expecting a java object with the
        EchoRequest request = new EchoRequest(true, "Parsed Data: \n"+data.toString());

        //Set our loopback utils last request
        echoService.addRequest(request);
        return request.toString();
    }

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(method = RequestMethod.GET, value="/echo")
    public String loopbackView(){
        return echoService.printRequests();
    }

}
