package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;


    @FindBy(id = "UserName")
    private WebElement usernameInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(id = "loginIn")
    private WebElement loginButton;

    @FindBy(partialLinkText = "Register as a")
    private WebElement registerNewUserLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void loginUserToAccount(String userName, String userPassword) {
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(userPassword);
        loginButton.click();
    }

    public RegisterUserPage registerNewUser() {
        registerNewUserLink.click();
        return new RegisterUserPage(driver);
    }


}
