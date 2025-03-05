package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import factory.BasePage;

public class LoginTests extends BasePage {

    private final By LOGIN_TEXT = By.xpath("//div[@class='container body-content']//h2");

    private final By WEBSITE_LOGO = By.xpath("//div[@class='col-md-5']//img");





    @Test
    public void loginUserWithoutCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();


        Assert.assertEquals(driver.findElement(LOGIN_TEXT).getText(), "Login.", "Login text is different");
        Assert.assertTrue(driver.findElement(WEBSITE_LOGO).isDisplayed(), "Logo is not displayed");
    }

}
