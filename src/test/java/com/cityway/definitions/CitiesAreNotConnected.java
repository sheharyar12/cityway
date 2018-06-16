package com.cityway.definitions;

import com.cityway.CitywayApplication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = CitywayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@ActiveProfiles("integration-test")
public class CitiesAreNotConnected {

    @LocalServerPort
    private int port;
    private String result;
    private String origin;
    private String destination;


    @Given("^the wrong origin city and destination city$")
    public void the_origin_city_and_destination_city() throws Throwable {
        origin = "wrong";
        destination = "wrong";
    }

    @When("^ConnectedController endpoint is executed with the wrong origin city and destination city$")
    public void connectedcontroller_endpoint_is_executed_with_the_origin_city_and_destination_city() throws Throwable {
        RestTemplate restTemplate = new RestTemplate();
        String testUrl = "http://localhost:" + port + " /connected?origin=" + origin + "&destination=" + destination;
        result = restTemplate.getForObject(testUrl,String.class);
    }

    @Then("^it should return a no to client$")
    public void it_should_return_a_yes_to_client() throws Throwable {
        Assert.assertEquals("no",result);
    }
}
