package com.cityway.service;

import org.apache.commons.collections4.BidiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name: ConnectedService
 * Description: Service that looks in the map if the two cities are connected.
 */
@Service
public class ConnectedService {

    private final BidiMap<String, String> cityMap;

    @Autowired
    public ConnectedService(BidiMap<String, String> cityMap) {
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
        if(cityMap.inverseBidiMap().containsKey(origin) && cityMap.inverseBidiMap().get(origin).equals(destination)){
            return true;
        }
        if (cityMap.containsKey(origin) && cityMap.get(origin).equals(destination)) {
            return true;
        }
        return false;
    }
}
