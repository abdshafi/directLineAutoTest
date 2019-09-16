package com.directline;

import com.directline.utilities.Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                 format ={"html:target/cucumber-html-report", "json:target/cucumber.json"},
                 tags = {"@test1"},
                 features ="src/test/resources/features",
                 glue = {"com.directline.utilities",
                         "com.directline.stepdefinitions"})

public class RunCuckesTest extends Setup {

}









