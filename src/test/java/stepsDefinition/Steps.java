package stepsDefinition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.MyDriverManager.initChromeDriver;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Steps {

    @Given("^Open the Chrome$")
    public void open_the_Firefox_and_launch_the_application() {
        WebDriverRunner.setWebDriver(initChromeDriver());
//        System.setProperty("webdriver.chrome.driver",
//                "src/drivers/chromedriver.exe");
//        System.setProperty("selenide.browser", "Chrome");
    }

    @When("^Open web page$")
    public void enter_the_Username_and_Password() {
        open("https://www.epam.com/");
    }

    @Then("^Check element$")
    public void reset_the_credential() {
        String text = $(By.xpath(".//a[contains(@class, 'cta-button-ui')]")).getText();
        Assert.assertEquals(text, "CONTACT US");
    }
}
