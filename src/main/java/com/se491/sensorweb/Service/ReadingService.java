package com.se491.sensorweb.Service;

import com.se491.sensorweb.Leafnode.Leafnode;
import com.se491.sensorweb.Leafnode.LeafnodeRepository;
import com.se491.sensorweb.Reading.Reading;
import com.se491.sensorweb.Reading.SensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadingService {

    @Autowired
    private SensorReadingRepository readingRepository;

    public ReadingService() {

    }

    /**
     * Gets all of the home nodes in the database
     * @return all of the home nodes
     */

//    public Reading getReading(Long homenodeId, Long leafnodeId, Long readingId){
//        return leafnodeRepository.findOne(id);
//    }

    public Reading addReading(Reading reading){
        return readingRepository.save(reading);
    }

}
