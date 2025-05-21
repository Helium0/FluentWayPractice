package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage  {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn-lg') and text()='Visit now »']")
    private WebElement visitNowButton;

    @FindBy(xpath = "//a[contains(@class,'btn btn-default') and text()='Learn more »']")
    private WebElement learnMoreButton;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn-lg') and text()='Udemy']")
    private WebElement udemyButton;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn-lg') and text()='YouTube']")
    private WebElement youtubeButton;

    @FindBy(xpath = "//a[contains(@class,'btn btn-default') and text()='Get Source code »']")
    private WebElement sourceCodeButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnVisitNowButton() {
        visitNowButton.click();
    }

    public void clickOnLearnMoreButton() {
        learnMoreButton.click();
    }

    public void clickOnUdemyButton() {
        udemyButton.click();
    }

    public void clickOnYoutubeButton() {
        youtubeButton.click();
    }

    public void clickOnGetSourceButton() {
        sourceCodeButton.click();
    }




}
