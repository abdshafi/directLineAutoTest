package com.blackcat.stepdefinitions;

import com.blackcat.pageobjects.Login;
import com.blackcat.utilities.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bothees on 11/10/2016.
 */
public class Loginsteps {

    final static Logger logger = Logger.getLogger(Homepagesteps.class);

    private static String expectedstring = "Boothiraj";

    Login login = PageFactory.initElements(DriverFactory.driver,Login.class);


    @Given("^user am on LoginPage$")
    public void user_am_on_LoginPage() throws Throwable {
        login.goToLoginpage();
    }

    @When("^user enter valid username$")
    public void user_enter_valid_username() throws Throwable {
        login.enteruserName();
    }

    @When("^user enter valid password$")
    public void user_enter_valid_password() throws Throwable {
        login.enteruserPassword();
    }
    @When("^user click on login button$")
    public void user_click_on_login_button() throws Throwable {
        login.clickLoginButton();
    }

    @Then("^user should see the homepage$")
    public void user_should_see_the_homepage() throws Throwable {
        Assert.assertEquals(expectedstring,login.verifyHomepage());
    }

}
