package com.blackcat.pageobjects;

import com.blackcat.utilities.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bothees on 27/11/2018.
 */
public class Homepage extends DriverFactory {

    Common common = new Common();

    @FindBy(css = ".icon.calendar")
    private WebElement history;


    public void clickOnHistoryButton() {
       common.waitForVisibilityOfElement(history).click();
    }

    public boolean verifyHistory() {
        return true;
    }
}
