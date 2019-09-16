package com.directline.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;


public class DriverFactory {

    public static WebDriver driver;

    private static final String CHROME_DRIVER= "webdriver.chrome.driver";

    private static final String FIREFOX_DRIVER= "webdriver.gecko.driver";

    private static ChromeOptions options;

    private static final String workingDir = System.getProperty("user.dir");

    TestContext testContext  = TestContext.getInstance();


    public void initialiseDriver() {
        if(driver!=null){
            return;
        }
        getLocalDriver();
    }

    private WebDriver getLocalDriver() {
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            ChromeOptions options = getChromeCustomOptions();
//            System.setProperty(CHROME_DRIVER, testContext.readproperty("CHROME.DRIVER"));
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver = new ChromeDriver(options);
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

    private ChromeOptions getChromeCustomOptions() {
        HashMap<String, String> chromePreferences = new HashMap();
        chromePreferences.put("profile.password_manager_enabled", "false");
        chromePreferences.put("credentials_enable_service", "false");
        chromePreferences.put("download.default_directory", workingDir + File.separator + "downloads");
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePreferences);
        options.addArguments("--disable-web-security");
        options.addArguments("--test-type");
        options.addArguments("--start-fullscreen");
        options.setCapability("chrome.switches", Collections.singletonList("--no-default-browser-check"));
        options.setCapability("chrome.switches", Collections.singletonList("--disable-logging"));
        options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        options.setCapability("chrome.verbose", false);
        return options;
    }

}
