package project.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.time.Duration;

public class Browser {
    public static void setBrowserConfig() throws Exception {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().deleteAllCookies();
    }

    public static void getURL(String url) throws Exception {
        Driver.getDriver().get(url);
    }

    public static WebDriverWait waitInit() throws Exception {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    public void switchToIframeByWebElement(By locator) throws Exception {
        WebElement element = Driver.getDriver().findElement(locator);
        Driver.getDriver().switchTo().frame(element);
    }
}
