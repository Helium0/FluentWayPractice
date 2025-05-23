package tests;

import factory.BasePage;
import factory.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.NavigationBarPage;

import java.util.List;

public class EmployeeListPageTests extends BasePage {

    private WebDriver driver;
    private NavigationBarPage navigationBarPage;


    @Test
    public void showAllEmployees() {
        driver = DriverManagement.getDriver();
        navigationBarPage = new NavigationBarPage(driver);
        navigationBarPage.clickEmployeeList();
        List<WebElement> eee = driver.findElements(By.xpath("//tbody//tr"));
        eee.stream().forEach(element -> System.out.print("||"+element.getText()+"||"+"\n"));
    }

}
