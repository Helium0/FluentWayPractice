package tests;

import factory.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.LoginPage;
import factory.BasePage;

public class LoginTests extends BasePage {


    private NavigationBarPage navigationBarPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private final By USER_NAME_ERROR = By.xpath("//span[@for='UserName']");
    private final By USER_PASSWORD_ERROR = By.xpath("//span[@for='Password']");
    private final By INVALID_LOGIN_ERROR = By.xpath("//div[@class='validation-summary-errors text-danger']");


    @Test
    public void userCantLoginWithoutCredentials() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("","");

        Assert.assertEquals(driver.findElement(USER_NAME_ERROR).getText(), "The UserName field is required.");
        Assert.assertEquals(driver.findElement(USER_PASSWORD_ERROR).getText(), "The Password field is required.");
    }

    @Test
    public void userCantLoginWithIncorrectCredentials() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("Patryk","Tester666");

        Assert.assertEquals(driver.findElement(INVALID_LOGIN_ERROR).getText(), "Invalid login attempt.");
    }

    @Test
    public void userCantLoginWithoutPassword() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("Patryk","");

        Assert.assertEquals(driver.findElement(USER_PASSWORD_ERROR).getText(), "The Password field is required.");
    }

    @Test
    public void userCantLoginWithoutUserName() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("","Tester666");

        Assert.assertEquals(driver.findElement(USER_NAME_ERROR).getText(), "The UserName field is required.");
    }

    @Test
    public void userCanClickOnRememberCheckbox() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.clickOnRememberMeCheckbox();

        Assert.assertTrue(loginPage.getRememberMeCheckbox().isSelected(), "Checkbox is not selected");
    }

}
