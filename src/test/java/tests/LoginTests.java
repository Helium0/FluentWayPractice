package tests;

import factory.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import factory.BasePage;

public class LoginTests extends BasePage {


    private HomePage homePage;
    private LoginPage loginPage;
    private final By USER_NAME_ERROR = By.xpath("//span[@for='UserName']");
    private final By USER_PASSWORD_ERROR = By.xpath("//span[@for='Password']");


    @Test
    public void userCantLoginWithoutCredentials() {
        WebDriver driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickLogin();
        loginPage.loginUserToAccount("","");

        Assert.assertEquals(driver.findElement(USER_NAME_ERROR).getText(), "The UserName field is required.");
        Assert.assertEquals(driver.findElement(USER_PASSWORD_ERROR).getText(), "The Password field is required.");

    }

}
