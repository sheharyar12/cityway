package com.cityway.config;

import com.cityway.util.MappingHelperUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
     * Name: bidiMap
     * Description: Reads everything from the bufferedReader and splits the cities
     * by comma. Comma is configurable in yml for future purposes. Uses custom utility
     * to map cities and map cities bidirectionally
     * @return BidiMap - this map contains <city, city>.
     */
    @Bean
    public Map<String, Set<String>> bidiMap() throws IOException {
        Map<String, Set<String>> mappedCities = new HashMap<>();
        Path path = Paths.get(filePath);
        try {
            mappedCities = MappingHelperUtil.mapCities(path, delimiter);
            MappingHelperUtil.mapBidirectionalCities(mappedCities);
        }catch (IOException | NullPointerException e){
            log.error("Not able to read cities from file");
        }
        log.info(String.valueOf(mappedCities));
        return mappedCities;
    }

}
