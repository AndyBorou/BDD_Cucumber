package stepsDefinition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.MyDriverManager.initChromeDriver;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;


public class Steps {

    @DisplayName("open Chrome")
    @Step
    @Given("^Open the Chrome$")
    public void open_the_Chrome_and_launch_the_application() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverRunner.setWebDriver(initChromeDriver());
//        System.setProperty("webdriver.chrome.driver",
//                "src/drivers/chromedriver.exe");
//        System.setProperty("selenide.browser", "Chrome");
    }

    @Step
    @When("^Open web page$")
    public void enter_the_Username_and_Password() {
        open("https://www.epam.com/");
    }

    @Then("^Check element$")
    public void reset_the_credential() {
        String text = $(By.xpath(".//a[contains(@class, 'cta-button-ui')]")).getText();
        Assert.assertEquals(text, "CONTACT US");
        makeScreenShot();
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
