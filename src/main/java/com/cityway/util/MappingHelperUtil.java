package com.cityway.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Name: MappingHelperUtil
 * Description: A utility class made to create mapping from a text file and create bidirectional mapping.
 */
public class MappingHelperUtil {

    /**
     * Name: mapCities
     * Description: Maps cities from a text file which contains a delimiter in between two cities
     * @param path
     * @param delimiter
     * @return
     * @throws IOException
     */
    public static Map<String, Set<String>> mapCities(Path path, String delimiter) throws IOException, NullPointerException {
        String cities;
        Map<String, Set<String>> mappedCities = new HashMap<>();
        Set<String> correspondingCities;
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        for(String line: (Iterable<String>) lines::iterator) {
            correspondingCities = new HashSet<>();
            String[] splitCities = line.split(delimiter);
            if (mappedCities.containsKey(splitCities[0].trim())) {
                correspondingCities = mappedCities.get(splitCities[0].trim());
            }
            correspondingCities.add(splitCities[1].trim());
            mappedCities.put(splitCities[0].trim(), correspondingCities);
        }
        return mappedCities;
    }

    /**
     * Name: mapBidirectionalCities
     * Description: Maps the cities bidirectioanally to fullfill the scenario for a
     * destination to be also an origin. The destination cities acting as
     * origin will help find if two cities are connected.
     * @param citiesMap
     * @return biDirectionalCitiesMap
     */
    public static Map<String, Set<String>> mapBidirectionalCities(Map<String, Set<String>> citiesMap){
        Map<String, Set<String>> biDirectionalCitiesMap = new HashMap<>();
        citiesMap.entrySet().stream().forEach(entryCity -> { // loop through the map
            entryCity.getValue().stream().forEach(city -> { //iterate through the Set , get the index value (city) from the Set
                if(!citiesMap.containsKey(city)){ // if the map does not contain the city
                    Set<String> biDirectionCity = new HashSet<>();// create a new set
                    biDirectionCity.add(entryCity.getKey());// add it to the biDirectionCity
                    biDirectionalCitiesMap.put(city,biDirectionCity);//put it in the temporary biDirectionalCitiesMap variable
                }else if(citiesMap.containsKey(city)){ //if it does contain the city
                    citiesMap.get(city).add(entryCity.getKey());// then get the original set and add the city on top of it.
                }
            });
        });
        //put the whole bidirectionalMap into citiesMap ( combine them ) this mapp will now contain original values and bidirectional values.
        citiesMap.putAll(biDirectionalCitiesMap);
        return citiesMap;
    }
}
