package com.se491.sensorweb.Service;

import com.se491.sensorweb.HomeNode.HomeNode;
import com.se491.sensorweb.HomeNode.HomeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    public HomeNode getHomeNode(Long id){
        return homeNodeRepository.findOne(id);
    }

}
