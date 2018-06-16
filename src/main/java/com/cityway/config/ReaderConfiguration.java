package com.cityway.config;

import com.cityway.model.City;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Name: ReaderConfiguration
 * Description: ReaderConfiguration will create fileReader, BufferedReaders as beans. We are assuming that this is
 * fileReader and bufferedReader will always be singletons. This configuration Class is designed to load the text file
 * at spring boot time and put all the cities in a bidirectional Map.
 * @author Shehar Yar
 */
@Data
@Slf4j
@Configuration
@ConfigurationProperties("configuration")
public class ReaderConfiguration {

    private String filePath;
    private String delimiter;

    /**
     * Name: fileReader
     * Description: FileReader will be instantiated as a singleton. This
     * will read the filePath variable to load the file. filePath variable
     * is configurable from the application yml file.
     * @return singleton bean on FileReader
     */
    @Bean
    public FileReader fileReader(){
        FileReader filereader = null;
        try {
            filereader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            log.error("File cannot be found." , e.getClass());
        }
        return filereader;
    }

    /**
     * Name: bufferedReader
     * Description: This method at boot time will read the character input stream
     * from the fileReader.
     * @param fileReader - contains the file to be read from bufferedReader.
     * @return singleton bean on FileReader
     */
    @Bean
    public BufferedReader bufferedReader(FileReader fileReader){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(fileReader);
        }catch (NullPointerException e){
            log.error("Could not read file", e.getClass());
        }
        return bufferedReader;
    }

    /**
     * Name: bidiMap
     * Description: Reads everything from the bufferedReader and splits the cities
     * by comma. Comma is configurable in yml for future purposes.
     * @param reader - contains the read character stream
     * @return BidiMap - this map contains <city, city>.
     */
    @Bean
    public BidiMap<City, City> bidiMap(BufferedReader reader) throws IOException {
        String cities;
        BidiMap<City, City> mappedCities = new DualHashBidiMap<>();
        City firstCity, secondCity;
        try {
            while ((cities = reader.readLine()) != null) {
                String[] splitCities = cities.split(",");
                firstCity = City.builder()
                        .name(splitCities[0])
                        .build();
                secondCity = City.builder()
                        .name(splitCities[1])
                        .build();
                mappedCities.put(firstCity, secondCity);
            }
        }catch (NullPointerException e){
            log.error("Not able to read cities from file");
        }
        return mappedCities;
    }
}
