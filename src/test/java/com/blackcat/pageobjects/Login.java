package com.blackcat.pageobjects;

import com.blackcat.utilities.DriverFactory;
import com.blackcat.utilities.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bothees on 27/11/2018.
 */
public class Login {

    @FindBy(id = "emailAddress")
    private WebElement usrname;

    @FindBy(id = "password")
    private WebElement passwd;

    @FindBy(id = "signInButton")
    private WebElement signin;

    @FindBy(xpath = "//*[@id='content-wrap']/div/div/section/header/div[1]/h1")
    private WebElement loginHead;

    @FindBy(id ="signedInUserSignOut")
    private WebElement signout;

    TestContext testContext  = TestContext.getInstance();

    Common common = new Common();

    private String url = testContext.readproperty("login.url") ;
    private String username = testContext.readproperty("login.username");
    private String password = testContext.readproperty("login.password") ;


    public void goToLoginpage(){
            DriverFactory.driver.get("https://www.moneysupermarket.com/my-account/sign-out");
            DriverFactory.driver.get(url);
    }

    public void enteruserName(){
        usrname.clear();
        usrname.sendKeys(username);
    }

    public void enteruserPassword(){
        passwd.clear();
        passwd.sendKeys(password);
    }

    public void clickLoginButton(){
        signin.click();
        url = DriverFactory.driver.getCurrentUrl();
    }

    public String verifyHomepage(){
        String text = common.waitForVisibilityOfElement(loginHead).getText();
        System.out.println("Actual String:"+text);
        return text;
    }



}
