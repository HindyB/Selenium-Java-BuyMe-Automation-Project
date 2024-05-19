package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.Constants;

// Set up web driver in Singleton
public class WebDriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        if (driver == null) {
            String type = BasePage.getData("browserType");
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver() ;
            } else {
                System.setProperty("webdriver.edge.driver", Constants.EDGEDRIVER_PATH);
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}