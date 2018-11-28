package com.blackcat;

import com.blackcat.utilities.Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by bothees on 27/11/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
                 format ={"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
                 features ="src/test/resources/features",
                 glue = {"com.blackcat.utilities",
                         "com.blackcat.stepdefinitions"})

public class CucumberRunner extends Setup {

}









