package com.blackcat.stepdefinitions;

import com.blackcat.pageobjects.Homepage;
import com.blackcat.pageobjects.Login;
import com.blackcat.utilities.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepagesteps {

    final static Logger logger = Logger.getLogger(Homepagesteps.class);

    Login login = PageFactory.initElements(DriverFactory.driver,Login.class);

    Homepage home = PageFactory.initElements(DriverFactory.driver,Homepage.class);


    @Given("^user logged on Homepage$")
    public void user_logged_on_Homepage() throws Throwable {
        logger.info("user logging in to mysupermarket");
        login.goToLoginpage();
        login.enteruserName();
        login.enteruserPassword();
        login.clickLoginButton();
    }

    @Given("^click on All history menu$")
    public void click_on_All_history_menu() throws Throwable {
        logger.info("Clicking on History button");
        home.clickOnHistoryButton();
    }

    @Then("^user should see all the information$")
    public void user_should_see_all_the_information() throws Throwable {
        Assert.assertTrue("verified",home.verifyHistory());
    }

}
