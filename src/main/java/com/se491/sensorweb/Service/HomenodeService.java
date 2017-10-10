package com.se491.sensorweb.Service;

import com.se491.sensorweb.Homenode.Homenode;
import com.se491.sensorweb.Homenode.HomenodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomenodeService {

    @Autowired
    private HomenodeRepository homenodeRepository;

    public HomenodeService() {

    }

    /**
     * Gets all of the home nodes in the database
     * @return all of the home nodes
     */
    public List<Homenode> getAllHomenodes() {
        return homenodeRepository.findAll();
    }

    public Homenode getHomenode(Long id){
        return homenodeRepository.findOne(id);
    }

    public Homenode addHomenode(Homenode homenode){
        return homenodeRepository.save(homenode);
    }

    public Homenode getHomenodeByUnique(String unique){
        return homenodeRepository.findByUniqueId(unique);
    }

}
