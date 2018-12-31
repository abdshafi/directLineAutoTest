package com.blackcat.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


/**
 * Created by bothees on 27/11/2018.
 */
public class DriverFactory {

    public static WebDriver driver;

    private static final String CHROME_DRIVER= "webdriver.chrome.driver";

    private static final String FIREFOX_DRIVER= "webdriver.gecko.driver";

    TestContext testContext  = TestContext.getInstance();


    public void initialiseDriver() {
        if(driver!=null){
            return;
        }
        getLocalDriver();
    }

    private WebDriver getLocalDriver() {
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_DRIVER, testContext.readproperty("CHROME.DRIVER"));
            driver = new ChromeDriver();
        } else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
            System.setProperty(FIREFOX_DRIVER, testContext.readproperty("FIREFOX.DRIVER"));
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.addPreference("marionette", false);
            ffOptions.setAcceptInsecureCerts(true);
            driver = new FirefoxDriver(ffOptions);
        }
        return driver;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
