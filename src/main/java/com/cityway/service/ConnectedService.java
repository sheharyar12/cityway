package com.cityway.service;

import com.cityway.model.City;
import org.apache.commons.collections4.BidiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name: ConnectedService
 * Description: Service that looks in the map if the two cities are connected.
 */
@Service
public class ConnectedService {

    private final BidiMap<City, City> cityMap;

    @Autowired
    public ConnectedService(BidiMap<City, City> cityMap) {
        this.cityMap = cityMap;
    }

    /**
     * Name: isConnected
     * Description: return true if the two cities are connected. Returns
     * false if they are not connected.
     * @param city1
     * @param city2
     * @return boolean - true if connected, false if not connected
     */
    public boolean isConnected(City city1, City city2){
        System.out.println(city1);
        System.out.println(city2);
        if(cityMap.getKey(city2).equals(city1)){
            return true;
        }else{
            return false;
        }
    }
}
