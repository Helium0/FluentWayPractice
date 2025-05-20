package tests;

import factory.BasePage;
import factory.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WaitsUtils;

public class HomePageTests extends BasePage {

    private WebDriver driver;
    private HomePage homePage;
    private final By NEXT_PAGE_INFORMARION = By.xpath("//div[@id='main-message']//h1");
    private final By ACCEPT_YOUTUBE_COOKIES = By.xpath("//span[contains(text(),'Accept all')]");
    private final By YOUTUBE_LOGO = By.xpath("//yt-icon[@id='logo-icon']");


    @Test
    public void checkLearnMoreButtonFunctionality() {
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnLearnMoreButton();

        Assert.assertEquals(driver.findElement(NEXT_PAGE_INFORMARION).getText(), "This site can’t be reached");
    }

    @Test
    public void checkCoursesButtonsFunctionality() {
        driver = DriverManagement.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnUdemyButton();

        Assert.assertEquals(driver.getTitle(),"Karthik KK | Software Architect, Consultant,Youtuber and Best Seller" +
                " | Udemy");
        driver.navigate().back();
        homePage.clickOnYoutubeButton();
        driver.findElement(ACCEPT_YOUTUBE_COOKIES).click();
        WaitsUtils.waitForWebelement(driver, driver.findElement(YOUTUBE_LOGO));

        Assert.assertEquals(driver.getTitle(),"Execute Automation - YouTube");
    }

}
