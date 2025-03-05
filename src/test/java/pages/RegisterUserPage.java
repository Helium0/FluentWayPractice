package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterUserPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerUserButton;

    @FindBy(xpath = "//div[contains(@class,'text-danger')]//li")
    private List<WebElement> errorsMessageList;


    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickRegisterUserButton() {
        registerUserButton.click();
    }

    public List<WebElement> registerUserWebErrors() {
        return this.errorsMessageList;
    }

}
