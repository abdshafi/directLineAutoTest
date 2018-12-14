package com.blackcat.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by bothees on 27/11/2018.
 */
public class DriverFactory {

    public static WebDriver driver;

    private static final String CHROME_DRIVER= "webdriver.chrome.driver";

    private static final String FIREFOX_DRIVER= "webdriver.gecko.driver";

    TestContext testContext  = TestContext.getInstance();

    private static final String workingDir = System.getProperty("user.dir");

    private static final String workingOS = System.getProperty("os.name").toLowerCase();

    private static ChromeOptions options;


    public void initialiseDriver() {
        if(driver!=null){
            return;
        }
        getLocalDriver();
    }

    private WebDriver getLocalDriver() {
        if (workingOS.contains("mac")) {
            options.addArguments("--kiosk");
        }
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            DesiredCapabilities capabilities = getChromeDesiredCapabilities();
            System.setProperty(CHROME_DRIVER, testContext.readproperty("CHROME.DRIVER"));
            driver = new ChromeDriver(capabilities);
        } else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
            System.setProperty(FIREFOX_DRIVER, testContext.readproperty("FIREFOX.DRIVER"));
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    private DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        HashMap<String, String> chromePreferences = new HashMap();
        chromePreferences.put("profile.password_manager_enabled", "false");
        chromePreferences.put("credentials_enable_service", "false");
        chromePreferences.put("download.default_directory", workingDir + "/downloads");
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePreferences);
        options.addArguments("--disable-web-security");
        options.addArguments("--test-type");

        capabilities.setCapability("chrome.switches", Collections.singletonList("--no-default-browser-check"));
        capabilities.setCapability("chrome.switches", Collections.singletonList("--disable-logging"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("chrome.verbose", false);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("nativeEvents", true);
        return capabilities;
    }



}
