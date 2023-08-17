import org.testng.Assert;
import org.testng.annotations.Test;
import project.browser.Browser;
import project.driver.Driver;
import project.pages.MainPage;
import project.pages.PassportPage;

public class TestCase_4 extends BaseTest{
    public static final String URL = "https://yandex.ru/";
    public static final String LOGIN = "unflesed7";
    @Test
    public void backButton() throws Exception {
        MainPage mainPage = new MainPage(Driver.getDriver());
        PassportPage passportPage = new PassportPage(Driver.getDriver());

        Browser.getURL(URL);

        mainPage.closePopUp();

        Assert.assertTrue(mainPage.isOpened(), "Main page is not opened!");

        mainPage.clickEnterButton();

        Assert.assertTrue(passportPage.isPassportPageOpened(), "Passport page is not opened!");

        passportPage.inputLogin(LOGIN);
        passportPage.clickEnterButton();
        passportPage.waitUntilPasswordFormIsVisible();

        Assert.assertTrue(passportPage.isPasswordFormOpened(), "Password form is not opened!");

        passportPage.clickBackButton();

        Assert.assertTrue(passportPage.isLoginFormOpened(), "Login form is not opened!");
    }
}
