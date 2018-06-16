package com.cityway.controller;

import com.cityway.service.ConnectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connected")
public class ConnectedController {

    private final ConnectedService connectedService;

    @Autowired
    public ConnectedController(ConnectedService connectedService) {
        this.connectedService = connectedService;
    }

    @GetMapping
    public String isConnectedRequest(@RequestParam String origin, @RequestParam String destination){
        if(connectedService.isConnected(origin,destination)){
            return "yes";
        }else{
            return "no";
        }
    }

}
