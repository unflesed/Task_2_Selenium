package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.browser.Browser;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.xpath("//input[@id='text']");
    private By avatar = By.xpath("//span[contains(@class, 'avatar__image-wrapper')]");
    private By mailLink = By.cssSelector(".Root");
    private By iFrame = By.xpath("//iframe[@class='usermenu-portal__iframe']");
    private By loginText = By.xpath("//span[contains(@class, 'Subname')]");

    public boolean isOpened(){
        if (driver.findElement(searchInput).isDisplayed() && driver.findElement(avatar).isDisplayed()) {
            return true;
        }

        return false;
    }

    public void clickAvatar(){
        driver.findElement(avatar).click();
    }

    public By getIFrameXpath(){

        return iFrame;
    }

    public String getLoginText(){

        return driver.findElement(loginText).getText();
    }

    public void waitUntilSearchPageIsOpened() throws Exception {
        Browser.waitInit().until(ExpectedConditions.visibilityOfElementLocated(avatar));
    }

    public void waitUntilAccountFormIsOpened() throws Exception {
        Browser.waitInit().until(ExpectedConditions.visibilityOfElementLocated(loginText));
    }
}
