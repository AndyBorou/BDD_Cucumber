package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.qameta.allure.Step;
import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyDriverManager {

    @Step("Init Chrome driver")
    public static WebDriver initChromeDriver() {
        Configuration.browser = "firefox";
        FirefoxDriverManager.getInstance().setup();
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("firefox");
        browser.setVersion("66.0");
        browser.setCapability("enableVNC", true);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    browser
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
