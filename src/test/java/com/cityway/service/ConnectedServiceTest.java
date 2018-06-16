package com.cityway.service;

import com.cityway.model.City;
import org.apache.commons.collections4.BidiMap;
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
    private BidiMap<City, City> cityMap;
    private ConnectedService connectedService;

    @Before
    public void ConnectedServiceTest(){
        MockitoAnnotations.initMocks(this);
        connectedService = new ConnectedService(cityMap);
    }

    @Test
    public void isConnected() {
        City city1 = City.builder()
                .name("Boston")
                .build();
        City city2 = City.builder()
                .name("New York")
                .build();
        when(cityMap.getKey(city2)).thenReturn(city1);
        boolean expected = true;
        boolean actual = connectedService.isConnected(city1,city2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isNotConnected() {
        City city1 = City.builder()
                .name("Boston")
                .build();
        City city2 = City.builder()
                .name("New York")
                .build();
        City wrongCity = City.builder()
                .name("wrong city")
                .build();
        when(cityMap.getKey(city2)).thenReturn(city1);
        boolean expected = false;
        boolean actual = connectedService.isConnected(wrongCity, city2);
        Assert.assertEquals(expected,actual);
    }
}