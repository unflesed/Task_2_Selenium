package project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver = null;

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        return driver;
    }

    public  static void quit(){
        driver.quit();
        driver = null;
    }
}
