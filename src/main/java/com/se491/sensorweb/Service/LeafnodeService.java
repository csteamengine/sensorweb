package com.se491.sensorweb.Service;

import com.se491.sensorweb.Leafnode.Leafnode;
import com.se491.sensorweb.Leafnode.LeafnodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeafnodeService {

    @Autowired
    private LeafnodeRepository leafnodeRepository;

    public LeafnodeService() {

    }

    /**
     * Gets all of the home nodes in the database
     * @return all of the home nodes
     */

    public Leafnode getLeafnode(Long id, Long homenodeId){
        return leafnodeRepository.findOne(id);
    }

    public Leafnode getLeafnodeFromHomenode(Long id, Long homenodeId){
        return leafnodeRepository.findByLeafnodeIdAndHomenodeId(id, homenodeId);
    }

    public Leafnode addLeafnode(Leafnode leafnode){
        return leafnodeRepository.save(leafnode);
    }

}
