package com.htec.sandbox.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.htec.sandbox"},
        features = "src/test/resources/features",
        tags = "@createUseCase",
        plugin = {"progress",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html",
                "junit:target/cucumber-reports/cucumber.xml"}
        )
public class AllTestsRunner {
}



