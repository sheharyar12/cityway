package com.cityway.controller;

import com.cityway.exception.EmptyParameterException;
import com.cityway.service.ConnectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Name : ConnectedController
 * Description: Controller built with a rest endpoint to find if two cities are connected.
 */
@RestController
@RequestMapping("/connected")
public class ConnectedController {

    private final ConnectedService connectedService;

    @Autowired
    public ConnectedController(ConnectedService connectedService) {
        this.connectedService = connectedService;
    }

    /**
     * Name: isConnectedRequest
     * Description: Uses connectedService to find if two cities passed from the param
     * are connected
     * @param origin
     * @param destination
     * @return yes - if tow cities are connected , no - if not connected.
     */
    @GetMapping
    public String isConnectedRequest(@RequestParam String origin, @RequestParam String destination){
        if(origin.isEmpty() || destination.isEmpty()){
            throw new EmptyParameterException("origin or destination parameter cannot have a empty value");
        }
        if(connectedService.isConnected(origin,destination)){
            return "yes";
        }else{
            return "no";
        }
    }

}
