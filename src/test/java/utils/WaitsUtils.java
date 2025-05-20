package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsUtils {



    private static WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver,Duration.ofSeconds(10));
    }


    public static void waitForByElement(WebDriver driver, By locator) {
        webDriverWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void waitForWebelement(WebDriver driver, WebElement element) {
        webDriverWait(driver).until(ExpectedConditions.visibilityOf(element));
    }


}
