package com.cityway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Name: ConnectedService
 * Description: Service that looks in the map if the two cities are connected.
 */
@Service
public class ConnectedService {

    private final Map<String, Set<String>> cityMap;

    @Autowired
    public ConnectedService(Map<String, Set<String>> cityMap) {
        this.cityMap = cityMap;
    }

    /**
     * Name: isConnected
     * Description: return true if the two cities are connected. Returns
     * false if they are not connected.
     * @param origin
     * @param destination
     * @return boolean - true if connected, false if not connected
     */
    public boolean isConnected(String origin, String destination){
        if(cityMap.containsKey(origin) && cityMap.get(origin).contains(destination)){
            return true;
        }
        return false;
    }
}
