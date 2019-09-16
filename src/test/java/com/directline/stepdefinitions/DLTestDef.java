package com.directline.stepdefinitions;

import com.directline.pageobjects.VehicleSearchPage;
import com.directline.utilities.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DLTestDef {



    VehicleSearchPage veh = PageFactory.initElements(DriverFactory.driver,VehicleSearchPage.class);



    @Given("^User is on VWFSIPortal page$")
    public void user_is_on_vwfsiPortal_page() {
        veh.goToVehicleRegPage();

    }

    @When("^User enters the RegistrationNumber \"([^\"]*)\"$")
    public void user_enters_the_RegistrationNumber(String regNum) {
        veh.enterRegNumber(regNum);

    }

    @When("^Clicks on Find vehicle button$")
    public void clicks_on_Find_vehicle_button()  {
        veh.clickOnFindVehicleButton();

    }

    @Then("^I should see registration number \"([^\"]*)\" displayed$")
    public void results_for_the_registration_number_displayed(String regNum) {
        assertThat("Given RegNumber not found",veh.getResult(),containsString(regNum));
    }

    @Then("^I should see \"([^\"]*)\" message displayed$")
    public void invalid_registration_numer_message(String mes){

    }

}
