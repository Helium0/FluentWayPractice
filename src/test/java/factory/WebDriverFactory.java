package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;


    public static WebDriver getCorrectWeb(String webName) {

        switch (webName.toLowerCase()) {
            case "chrome": return new ChromeDriver();
            case "firefox": return new FirefoxDriver();
            case "edge": return new EdgeDriver();
            default:
                System.out.println(webName + "This is not correct driver");
        }

        return driver;
    }


}
