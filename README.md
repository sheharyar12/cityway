# Cityway
A Spring boot application that exposes a rest endpoint to figure out if two cities are connected. The cities are in a text file under resources/fixtures. Syntax to support the text file “origin(comman)destination”. If the origin leads to destination, then destination can also be origin. The mapping is done bidirectionally. The application caches the cities within the text file at spring boot time. This will increase performance when read.

### Prerequisites
- Gradle: to build
- STS, Intellij, or any other IDE: run within development environment. 
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

## Mapping output
```
{New York=[Boston], Newark=[Dallas, Philadelphia, Boston], Trenton=[Albany], Dallas=[Newark], Philadelphia=[Newark], Boston=[New York, Newark], Albany=[Trenton]}
```

## Running the tests
In repository run gradle clean build, this will run all the test cases and show result on window.
```
:compileJava
:processResources
:classes
:bootJar
:jar SKIPPED
:assemble
:compileTestJava
:processTestResources
:testClasses
:test
Executing test contextLoads [com.cityway.CitywayApplicationTests] with result: SUCCESS
Executing test isConnectedRequestEmptyException [com.cityway.controller.ConnectedControllerTest] with result: SUCCESS
Executing test isConnectedRequest [com.cityway.controller.ConnectedControllerTest] with result: SUCCESS
Executing test Given the origin city and destination city [Scenario: Passing two cities in parameter which contains in a text file should return a yes] with result: SUCCESS
Executing test When ConnectedController endpoint is executed with the origin city and destination city [Scenario: Passing two cities in parameter which contains in a text file should return a yes] with result: SUCCESS
Executing test Then it should return a yes to client [Scenario: Passing two cities in parameter which contains in a text file should return a yes] with result: SUCCESS
Executing test classMethod [Scenario: Passing two cities in parameter which contains in a text file should return a yes] with result: SUCCESS
Executing test Given the wrong origin city and destination city [Scenario: Passing two cities in parameter which does not contain in a text file should return a no] with result: SUCCESS
Executing test When ConnectedController endpoint is executed with the wrong origin city and destination city [Scenario: Passing two cities in parameter which does not contain in a text file should return a no] with result: SUCCESS
Executing test Then it should return a no to client [Scenario: Passing two cities in parameter which does not contain in a text file should return a no] with result: SUCCESS
Executing test classMethod [Scenario: Passing two cities in parameter which does not contain in a text file should return a no] with result: SUCCESS
Executing test isNotConnected [com.cityway.service.ConnectedServiceTest] with result: SUCCESS
Executing test isConnectedTest [com.cityway.service.ConnectedServiceTest] with result: SUCCESS
Executing test mapBidirectionalCities [com.cityway.util.MappingHelperUtilTest] with result: SUCCESS
Executing test mapCities [com.cityway.util.MappingHelperUtilTest] with result: SUCCESS
2018-06-17 19:57:59.941  INFO 4128 --- [       Thread-5] o.s.w.c.s.GenericWebApplicationContext   : Closing org.springframework.web.context.support.GenericWebApplicationContext@387316e5: startup date [Sun Jun 17 19:57:51 CDT 2018]; root of context hierarchy
2018-06-17 19:57:59.944  INFO 4128 --- [      Thread-10] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@57785ed6: startup date [Sun Jun 17 19:57:57 CDT 2018]; root of context hierarchy
2018-06-17 19:57:59.944  INFO 4128 --- [       Thread-7] o.s.w.c.s.GenericWebApplicationContext   : Closing org.springframework.web.context.support.GenericWebApplicationContext@4fc0347f: startup date [Sun Jun 17 19:57:55 CDT 2018]; root of context hierarchy
2018-06-17 19:57:59.944  INFO 4128 --- [      Thread-11] o.s.c.support.GenericApplicationContext  : Closing org.springframework.context.support.GenericApplicationContext@554865de: startup date [Sun Jun 17 19:57:59 CDT 2018]; root of context hierarchy
:check
:build

BUILD SUCCESSFUL in 17s
6 actionable tasks: 6 executed
7:58:00 PM: Task execution finished 'build'.
```
### Installing
1. Using git , clone the repository
2. Once cloned, in the directory of the project open Command and run "gradle clean build" assuming you have gradle installed.
3. Under build/libs folder you will see the jar created

### Running 
1. Open command on repository build/libs folder
2. run java -jar cityway-0.0.1-SNAPSHOT.jar --configuration.filePath="path to city.txt file"
3. (optional) If you are using a different delimiter instead of comma in the text file you can then pass --configuration.delimiter="your delimiter"
4. Once application is started on port 8080, then try hitting the endpoint http://localhost:8080/connected?origin=yourOriginCity&destination=yourDestinationCity

```
http://localhost:8080/connected?origin=Newark&destination=Boston
```

## Authors

* **Shehar Yar** 
