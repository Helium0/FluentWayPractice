package factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {


    @BeforeTest
    public void getWebPage() {
        WebDriver driver = WebDriverFactory.getCorrectWeb("chrome");
        DriverManagement.setDriver(driver);
        driver.get("http://eaapp.somee.com/");
        driver.manage().window().fullscreen();

    }


    @AfterTest
    public void tearDown() {
        DriverManagement.quitDriver();
    }

}
