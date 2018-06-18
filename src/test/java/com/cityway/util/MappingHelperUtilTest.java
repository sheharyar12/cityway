package com.cityway.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
public class MappingHelperUtilTest {

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws FileNotFoundException {
        MockitoAnnotations.initMocks(this);
        fileReader = new FileReader("src/test/resources/fixtures/city.txt");
        bufferedReader =  new BufferedReader(fileReader);

    }

    @Test
    public void mapCities() throws IOException {
        String cities;
        Map<String, Set<String>> expectedMappedCities = null;
        while ((cities = bufferedReader.readLine()) != null) {
            String[] splitCities =  cities.split(",");
            expectedMappedCities = new HashMap<>();
            Set<String> citySet = new HashSet<>();
            citySet.add(splitCities[1].trim());
            expectedMappedCities.put(splitCities[0].trim(), citySet);
        }

        FileReader actualFileReader = new FileReader("src/test/resources/fixtures/city.txt");
        BufferedReader bufferedReaderActual = new BufferedReader(actualFileReader);
        Map<String, Set<String>> actualMappedCities = MappingHelperUtil.mapCities(bufferedReaderActual, ",");

        Assert.assertEquals(expectedMappedCities,actualMappedCities);


    }

    @Test
    public void mapBidirectionalCities() throws IOException {
        Map<String, Set<String>> actualArgument = new HashMap<>();
        Set<String> citySet =  new HashSet<>();
        citySet.add("New York");
        actualArgument.put("Boston", citySet);

        Map<String, Set<String>> expected = new HashMap<>();
        Set<String> expectedSet =  new HashSet<>();
        expectedSet.add("New York");
        expected.put("Boston", expectedSet);
        expectedSet =  new HashSet<>();
        expectedSet.add("Boston");
        expected.put("New York", expectedSet);

        Map<String, Set<String>> actualMappedCities = MappingHelperUtil.mapBidirectionalCities(actualArgument);

        Assert.assertEquals(expected,actualMappedCities);
    }
}