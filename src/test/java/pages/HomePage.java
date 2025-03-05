package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    private WebDriver driver;

    @FindBy(id = "loginLink")
    private WebElement loginFromNavigationBarButton;

    @FindBy(id = "registerLink")
    private WebElement registerFromNavigationBarButton;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListNavigationBarutton;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage clickLogin() {
        loginFromNavigationBarButton.click();
        return new LoginPage(driver);
    }

    public RegisterUserPage clickRegister() {
        registerFromNavigationBarButton.click();
        return new RegisterUserPage(driver);
    }

    public EmployeeListPage clickEmployeeList() {
        employeeListNavigationBarutton.click();
        return new EmployeeListPage(driver);
    }

}
