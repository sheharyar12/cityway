package com.cityway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class CitywayApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CitywayApplication.class, args);
//		FileReader fileReader = new FileReader("C:\\Users\\Shehar\\IdeaProjects\\cityway\\src\\main\\resources\\city.txt");
//		BufferedReader bufferedReader =   new BufferedReader(fileReader);

	}
}
