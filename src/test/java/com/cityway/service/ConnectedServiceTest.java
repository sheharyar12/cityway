package com.cityway.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConnectedServiceTest {

    @Mock
    private Map<String, Set<String>> cityMap;
    private ConnectedService connectedService;

    @Before
    public void ConnectedServiceTest(){
        MockitoAnnotations.initMocks(this);
        connectedService = new ConnectedService(cityMap);
    }

    @Test
    public void isConnectedTest() {
        Set<String> set = new HashSet<>();
        set.add("Albany");
        when(cityMap.containsKey("Trenton")).thenReturn(true);
        when(cityMap.get("Trenton")).thenReturn(set);
        boolean expected = true;
        boolean actual = connectedService.isConnected("Trenton","Albany");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isNotConnected() {
        Set<String> set = new HashSet<>();
        set.add("wrong city");
        when(cityMap.containsKey("Trenton")).thenReturn(true);
        when(cityMap.get("Trenton")).thenReturn(set);
        boolean expected = false;
        boolean actual = connectedService.isConnected("Trenton","Albany");
        Assert.assertEquals(expected,actual);
    }
}