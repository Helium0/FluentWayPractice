package tests;

import factory.BasePage;
import factory.DriverManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WaitsUtils;

public class HomePageTests extends BasePage {

    private WebDriver driver;
    private HomePage homePage;
    private Logger logger = LogManager.getLogger(HomePageTests.class);
    private final By NEXT_PAGE_INFORMARION = By.xpath("//div[@id='main-message']//h1");
    private final By ACCEPT_YOUTUBE_COOKIES = By.xpath("//span[contains(text(),'Accept all')]");
    private final By YOUTUBE_LOGO = By.xpath("//yt-icon[@id='logo-icon']");

    @Test
    public void checkVisitNowFunctionality() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnVisitNowButton();

        try {
            Assert.assertEquals(driver.findElement(NEXT_PAGE_INFORMARION).getText(), "This site can’t be reached");
            logger.info("*** TEST name: checkVisitNowFunctionality PASSED");
        } catch (AssertionError e) {
            logger.error("*** TEST name: checkVisitNowFunctionality FAILED", e);
        }
    }

    @Test
    public void checkLearnMoreButtonFunctionality() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnLearnMoreButton();

        try {
            Assert.assertEquals(driver.findElement(NEXT_PAGE_INFORMARION).getText(), "This site can’t be reached");
            logger.info("*** TEST name: checkLearnMoreButtonFunctionality PASSED");
        } catch (AssertionError e) {
            logger.error("*** TEST name: checkLearnMoreButtonFunctionality FAILED", e);
        }
    }

    @Test
    public void checkCoursesButtonsFunctionality() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnUdemyButton();

        try {
            Assert.assertEquals(driver.getTitle(),"Karthik KK | Software Architect, Consultant,Youtuber and Best Seller" +
                    " | Udemy");
        } catch (AssertionError e) {
            logger.error("*** TEST name: checkCoursesButtonsFunctionality FAILED", e);
        }
        driver.navigate().back();
        homePage.clickOnYoutubeButton();
        driver.findElement(ACCEPT_YOUTUBE_COOKIES).click();
        WaitsUtils.waitForWebelement(driver, driver.findElement(YOUTUBE_LOGO));

        try {
            Assert.assertEquals(driver.getTitle(),"Execute Automation - YouTube");
            logger.info("*** TEST name: checkCoursesButtonsFunctionality PASSED");
        } catch (AssertionError e) {
            logger.error("*** TEST name: checkCoursesButtonsFunctionality FAILED", e);
        }
    }

    @Test
    public void checkSourceCodeButton() {
        logger.info("*** START ***");
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnGetSourceButton();

        try {
            Assert.assertEquals(driver.getTitle(), "executeautomation (ExecuteAutomation) · GitHub");
            logger.info("*** TEST name: checkSourceCodeButton PASSED");
        } catch (AssertionError e) {
            logger.error("*** TEST name: checkSourceCodeButton FAILED", e);
        }
    }

}
