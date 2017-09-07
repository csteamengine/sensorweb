package com.se491.sensorweb.Service;

import com.se491.sensorweb.Entity.EchoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EchoService {

    private ArrayList<EchoRequest> requests;

    public EchoService(){
        requests = new ArrayList<>();
    }

    public void addRequest(EchoRequest newRequest){
        if(requests.size() > 3){
            requests.remove(0);
        }
        requests.add(newRequest);
    }

    public List<EchoRequest> getRequests(){
        return requests;
    }

    public String printRequests(){
        String toReturn = "No Requests Available";

        if(requests.size() > 0){
            toReturn = "<!doctype html><html><head><title>Loopback View</title></head><body>";
            for(int i=0; i < requests.size(); i++){
                toReturn +="Request "+i+": <br>" + requests.get(i).toStringForHtml();
            }
            toReturn +="</body></html>";
        }

        return toReturn;
    }
}
