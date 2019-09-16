package com.directline.pageobjects;

import com.directline.utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleSearchPage {

    @FindBy(id = "vehicleReg")
    private WebElement searchBar;

    @FindBy(css = ".track-search")
    private WebElement findVehicle;

    @FindBy(css = ".result")
    private WebElement result;

    public void goToVehicleRegPage(){
        DriverFactory.driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
    }

    public void enterRegNumber(String regnum){
        searchBar.sendKeys(regnum);
    }

    public void clickOnFindVehicleButton(){
        findVehicle.click();
    }

    public String getResult(){
        return result.getText();

    }




}