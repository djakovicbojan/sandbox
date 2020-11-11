package com.htec.sandbox.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.htec.sandbox"},
        features = "src/test/resources/features",
        tags = "@people",
        plugin = {"pretty", "html:target/cucumber"}
        )
public class AllTestsRunner {
}



