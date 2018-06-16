package com.cityway;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {
                "com.cityway.definitions",
        },
        format = {
                    "pretty",
                    "html:target/reports/cucumber/html",
                    "json:target/cucumber.json",
                    "usage:target/usage.jsonx",
                    "junit:target/junit.xml"
        }
)
@RunWith(Cucumber.class)
public class CucumberIntegration {
}
