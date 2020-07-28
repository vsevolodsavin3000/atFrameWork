package stepDefinition;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.Proper;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InitialSteps {

    private final static Logger log = LoggerFactory.getLogger(InitialSteps.class);
    public static String href = null;

    @Before()
    public static void open(Scenario scenarioName) throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "MicrosoftWebDriver.exe");
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        Configuration.browser = Proper.getProps().getProperty("driver");
        if (Proper.getProps().getProperty("resolution").equals("maximize")) {
            Configuration.startMaximized = true;
        } else {
            Configuration.browserSize = Proper.getProps().getProperty("resolution");
        }

//        switch (Configuration.browser) {
//            case "chrome":
//                Configuration.browserCapabilities = new DesiredCapabilities();
//                Configuration.browserCapabilities.setCapability("profile.default_content_setting_values.notifications", 1);
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("enable-automation");
//                Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        }
        Configuration.timeout = 10000;
        //getWebDriver().manage().window().maximize();
        log.info("Scenario: " + scenarioName.getName());
    }

    @Before("@LogIn,@HrefsAfterLogOut,@InitRegistration")
    public static void openPage() throws IOException {
        href = Proper.getProps().getProperty("site");
        Selenide.open(href);
    }


    @After
    public static void close(Scenario scenarioName) {
        log.info("Scenario end: " + scenarioName.getName());
    }

    @AfterClass()
    public static void quit() {
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().quit();
    }
}
