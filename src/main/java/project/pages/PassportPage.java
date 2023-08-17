package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.browser.Browser;

public class PassportPage {
    private WebDriver driver;

    public PassportPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signInButton = By.xpath("//button[@id='passp:sign-in']");
    private By backButton = By.xpath("//a[@class='PreviousStepButton']");
    private By loginInput = By.xpath("//input[@id='passp-field-login']");
    private By passwordInput = By.xpath("//input[@id='passp-field-passwd']");
    private By nonExistentLogin = By.xpath("//div[@id='field:input-login:hint']");
    private By incorrectPassword = By.xpath("//div[@id='field:input-passwd:hint']");
    private By captchaImg = By.xpath("//img[@id='captcha-image']");

    public boolean isPassportPageOpened(){

        return driver.findElement(signInButton).isDisplayed();
    }

    public boolean isLoginFormOpened(){

        return driver.findElement(loginInput).isDisplayed();
    }

    public boolean isCaptchaImgVisible(){

        if (driver.findElements(captchaImg).size() > 0) {
            return true;
        }

        return false;
    }
    public void inputLogin(String login){

        driver.findElement(loginInput).sendKeys(login);
    }

    public void inputPassword(String password){

        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickEnterButton(){

        driver.findElement(signInButton).click();
    }

    public void clickBackButton(){

        driver.findElement(backButton).click();
    }
    public void waitUntilPasswordFormIsVisible() throws Exception {
        Browser.waitInit().until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
    }

    public void waitUntilNonExistentLoginMessageIsVisible() throws Exception {
        Browser.waitInit().until(ExpectedConditions.visibilityOfElementLocated(nonExistentLogin));
    }


    public void waitUntilIncorrectPasswordMessageIsVisible() throws Exception {
        Browser.waitInit().until(ExpectedConditions.visibilityOfElementLocated(incorrectPassword));
    }

    public boolean isPasswordFormOpened(){

        return driver.findElement(passwordInput).isDisplayed();
    }

    public String getNonExistentLoginMessage(){
        return driver.findElement(nonExistentLogin).getText();
    }

    public String getIncorrectPasswordMessage(){
        return driver.findElement(incorrectPassword).getText();
    }
}
