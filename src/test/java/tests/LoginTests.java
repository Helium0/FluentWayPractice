package tests;

import factory.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(LoginTests.class);
    private final By USER_NAME_ERROR = By.xpath("//span[@for='UserName']");
    private final By USER_PASSWORD_ERROR = By.xpath("//span[@for='Password']");
    private final By INVALID_LOGIN_ERROR = By.xpath("//div[@class='validation-summary-errors text-danger']");


    @Test
    public void userCantLoginWithoutCredentials() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("","");
        try {
            Assert.assertEquals(driver.findElement(USER_NAME_ERROR).getText(), "The UserName field is required.");
            Assert.assertEquals(driver.findElement(USER_PASSWORD_ERROR).getText(), "The Password field is required.");
            logger.info("*** TEST name: userCantLoginWithoutCredentials PASSED ***");
        } catch (AssertionError e) {
            logger.error("*** TEST name: userCantLoginWithoutCredentials FAILED", e);
            throw e;
        }

    }

    @Test
    public void userCantLoginWithIncorrectCredentials() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("Patryk","Tester666");

        try {
            Assert.assertEquals(driver.findElement(INVALID_LOGIN_ERROR).getText(), "Invalid login attempt.");
            logger.info("*** TEST name: userCantLoginWithIncorrectCredentials PASSED ***");
        } catch (AssertionError e) {
            logger.error("*** TEST name: userCantLoginWithIncorrectCredentials FAILED", e);
            throw e;
        }

    }

    @Test
    public void userCantLoginWithoutPassword() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("Patryk","");

        try {
            Assert.assertEquals(driver.findElement(USER_PASSWORD_ERROR).getText(), "The Password field is required.");
            logger.info("*** TEST name: userCantLoginWithoutPassword PASSED ***");
        } catch (AssertionError e) {
            logger.error("*** TEST name: userCantLoginWithoutPassword FAILED", e);
            throw e;
        }
    }

    @Test
    public void userCantLoginWithoutUserName() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.loginUserToAccount("","Tester666");

        try {
            Assert.assertEquals(driver.findElement(USER_NAME_ERROR).getText(), "The UserName field is required.");
            logger.info("*** TEST name: userCantLoginWithoutUserName PASSED ***");
        } catch (AssertionError e) {
            logger.error("*** TEST name: userCantLoginWithoutUserName FAILED", e);
            throw e;
        }
    }

    @Test
    public void userCanClickOnRememberCheckbox() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        navigationBarPage.clickLogin();
        loginPage.clickOnRememberMeCheckbox();

        try {
            Assert.assertTrue(loginPage.getRememberMeCheckbox().isSelected(), "Checkbox is not selected");
            logger.info("*** TEST name: userCanClickOnRememberCheckbox PASSED ***");
        } catch (AssertionError e) {
            logger.error("*** TEST name: userCanClickOnRememberCheckbox FAILED", e);
            throw e;
        }
    }

}
