package com.cityway.service;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConnectedServiceTest {

    @Mock
    private BidiMap<String, String> cityMap;
    private ConnectedService connectedService;

    @Before
    public void ConnectedServiceTest(){
        MockitoAnnotations.initMocks(this);
        connectedService = new ConnectedService(cityMap);
    }

    @Test
    public void isConnectedTest() {
        BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
        bidiMap.put("wrong","wrong");
        when(cityMap.inverseBidiMap()).thenReturn(bidiMap);
        when(cityMap.containsKey("Trenton")).thenReturn(true);
        when(cityMap.get("Trenton")).thenReturn("Albany");
        boolean expected = true;
        boolean actual = connectedService.isConnected("Trenton","Albany");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isConnectedInverseTest() {
        BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
        bidiMap.put("Albany","Trenton");
        when(cityMap.inverseBidiMap()).thenReturn(bidiMap);
        boolean expected = true;
        boolean actual = connectedService.isConnected("Albany","Trenton");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isNotConnected() {
        BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
        bidiMap.put("wrong","wrong");
        when(cityMap.inverseBidiMap()).thenReturn(bidiMap);
        boolean expected = false;
        boolean actual = connectedService.isConnected("Something","Something");
        Assert.assertEquals(expected,actual);
    }
}