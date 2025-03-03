package factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class BasePage extends WebDriverFactory {

    protected WebDriver driver;


    @BeforeTest
    public WebDriver getWebPage() {

        driver = WebDriverFactory.getCorrectWeb("chrome");
        driver.get("http://eaapp.somee.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();

        return driver;
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
