# Cityway
A Spring boot application that exposes a rest endpoint to figure out if two cities are connected. 
The cities are located in a text file under resources/fixtures. It goes by orging, destination. If the 
origin leads to destination then destination can also be origin. The mapping is done bidirectionaly.
The application caches the cities within the text file at spring boot time. This will increase performance at read.

### Prerequisites
- Gradle: to build
- STS, Intellij, or any other IDE : run withing development environment. 
- Git
- Java 8
- Lombok Plugin if running in development env (Can be found on intellij or STS market place for plugins)

## Getting Started
Create a text file that contains cities 
Example city.txt:
```

Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
Newark, Dallas
```
### Installing
1. Using git , clone the repository
2. Once cloned, in the directory of the project open Command and run "gradle clean build" assuming you have gradle installed.
3. Under build/libs folder you will see the jar created

### Running 
1. Open command on repository build/libs folder
2. run java -jar cityway-0.0.1-SNAPSHOT.jar --configuration.filePath="path to city.txt file"
3. (optional) If you are using a diffrent dilimeter instead of comma in the text file you can then pass --configuration.delimeter="your delimiter"
4. Once application is started on port 8080, then try hitting the endpoint http://localhost:8080/connected?origin=yourOriginCity&destination=yourDestinationCity

```
http://localhost:8080/connected?origin=Newark&destination=Boston
```

## Authors

* **Shehar Yar** 
