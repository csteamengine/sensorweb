package com.se491.sensorweb.Service;

import com.se491.sensorweb.HomeNode.HomeNode;
import com.se491.sensorweb.HomeNode.HomeNodeRepository;
import com.se491.sensorweb.User.User;
import com.se491.sensorweb.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeNodeService {

    @Autowired
    private HomeNodeRepository homeNodeRepository;

    public HomeNodeService() {

    }

    /**
     * Gets all of the home nodes in the database
     * @return all of the home nodes
     */
    public List<HomeNode> getAllHomeNodes() {
        return (List<HomeNode>) homeNodeRepository.findAll();
    }

}
