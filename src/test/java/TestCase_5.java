import org.testng.Assert;
import org.testng.annotations.Test;
import project.browser.Browser;
import project.driver.Driver;
import project.pages.MainPage;
import project.pages.PassportPage;

public class TestCase_5 extends BaseTest{
    public static final String URL = "https://yandex.ru/";
    public static final String LOGIN = "unflesed7";
    public static final String PASSWORD = "1";
    public static final int ATTEMPTS = 10;
    public static final int EXPECTED_RESULT = 6;
    @Test
    public void captchaAppearance() throws Exception {
        MainPage mainPage = new MainPage(Driver.getDriver());
        PassportPage passportPage = new PassportPage(Driver.getDriver());
        int counter = 0;

        Browser.getURL(URL);

        mainPage.closePopUp();

        Assert.assertTrue(mainPage.isOpened(), "Main page is not opened!");

        mainPage.clickEnterButton();

        Assert.assertTrue(passportPage.isPassportPageOpened(), "Passport page is not opened!");

        passportPage.inputLogin(LOGIN);
        passportPage.clickEnterButton();
        passportPage.waitUntilPasswordFormIsVisible();

        Assert.assertTrue(passportPage.isPasswordFormOpened(), "Password form is not opened!");

        for (int i = 0; i < ATTEMPTS; i++) {
            passportPage.inputPassword(PASSWORD);
            passportPage.clickEnterButton();
            counter++;
            Thread.sleep(500);
            if (passportPage.isCaptchaImgVisible()) {
                break;
            }
            passportPage.waitUntilIncorrectPasswordMessageIsVisible();
        }

        Assert.assertEquals(counter, EXPECTED_RESULT, "Count of attempts doesn't match!");

    }
}
