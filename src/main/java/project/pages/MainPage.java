package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selfLink = By.xpath("//a[contains(@class, 'headline__logo')]");
    private By enterButton = By.xpath("//a[contains(@class,'headline__personal-enter')]");
    private By popUpCloseButton = By.xpath("//button[@class='simple-popup__close']");
    private By popUp = By.xpath("//div[contains(@class,'simple-popup_hiding')]");

    public boolean isOpened(){

        return driver.findElement(selfLink).isDisplayed();
    }
    public void closePopUp(){
        if (driver.findElements(popUp).size() == 0) {
            driver.findElement(popUpCloseButton).click();
        }
    }

    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
}
