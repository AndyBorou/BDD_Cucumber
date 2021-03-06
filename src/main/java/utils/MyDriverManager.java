package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyDriverManager {


    public static WebDriver initChromeDriver() {
        Configuration.browser = "chrome";
        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("73.0");
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
