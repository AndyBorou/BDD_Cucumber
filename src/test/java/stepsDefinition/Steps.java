package stepsDefinition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.MyDriverManager.initChromeDriver;

import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;


public class Steps {

    @Given("^Open the Chrome$")
    public void open_the_Chrome_and_launch_the_application() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverRunner.setWebDriver(initChromeDriver());
//        System.setProperty("webdriver.chrome.driver",
//                "src/drivers/74/chromedriver.exe");
//        System.setProperty("selenide.browser", "Chrome");
    }

    @When("^Open web page$")
    public void openWebPage() {
        open("https://www.epam.com/");
    }

    @Then("^Check element$")
    public void checkButton() {
        String text = $(By.xpath(".//button/span[contains(@class, 'button__content')]")).getText();
        Assert.assertEquals(text, "ACCEPT");
        makeScreenShot();
    }

    @Attachment
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
