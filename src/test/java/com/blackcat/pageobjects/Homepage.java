package com.blackcat.pageobjects;

import com.blackcat.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepage extends DriverFactory {

    Common common = new Common();

    @FindBy(css = "ul#myProfileDetailsNav>li")
    private List<WebElement> history;


    public void clickOnHistoryButton() {
       common.waitForVisibilityOfElements(history).get(0).click();
    }

    public boolean verifyHistory() {
        return true;
    }
}
