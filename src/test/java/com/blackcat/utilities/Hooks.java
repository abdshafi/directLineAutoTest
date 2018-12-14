package com.blackcat.utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks extends DriverFactory{

    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        LOG.info("###### Starting Scenario : {} ######", scenario.getName());
    }


    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            embedScreenshot(scenario);
        }
        LOG.info("###### Finished Scenario : {} ######", scenario.getStatus());
    }

    private void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenShot = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException e) {

            }
        }
    }
}
