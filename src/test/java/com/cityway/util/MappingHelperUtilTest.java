package com.cityway.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
public class MappingHelperUtilTest {


    @Before
    public void setUp() throws FileNotFoundException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mapCities() throws IOException {
        Map<String, Set<String>> expectedMappedCities = null;
        Path path = Paths.get("src/test/resources/fixtures/city.txt");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        for(String cities: (Iterable<String>) lines::iterator) {
            String[] splitCities =  cities.split(",");
            expectedMappedCities = new HashMap<>();
            Set<String> citySet = new HashSet<>();
            citySet.add(splitCities[1].trim());
            expectedMappedCities.put(splitCities[0].trim(), citySet);
        }

        Path pathForActual = Paths.get("src/test/resources/fixtures/city.txt");
        Map<String, Set<String>> actualMappedCities = MappingHelperUtil.mapCities(pathForActual, ",");

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