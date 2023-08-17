import org.testng.Assert;
import org.testng.annotations.Test;
import project.browser.Browser;
import project.driver.Driver;
import project.pages.MainPage;
import project.pages.PassportPage;

public class TestCase_6 extends BaseTest{
    public static final String URL = "https://yandex.ru/";
    public static final String LOGIN = "";
    @Test
    public void emptyLogin() throws Exception {
        MainPage mainPage = new MainPage(Driver.getDriver());
        PassportPage passportPage = new PassportPage(Driver.getDriver());

        Browser.getURL(URL);
        mainPage.closePopUp();

        Assert.assertTrue(mainPage.isOpened(), "Main page is not opened!");

        mainPage.clickEnterButton();

        Assert.assertTrue(passportPage.isPassportPageOpened(), "Passport page is not opened!");

        passportPage.inputLogin(LOGIN);
        passportPage.clickEnterButton();

        passportPage.waitUntilNonExistentLoginMessageIsVisible();

        Assert.assertEquals(passportPage.getNonExistentLoginMessage(), "Логин не указан", "Message is incorrect!");
    }
}
