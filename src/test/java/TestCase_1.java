import org.testng.Assert;
import org.testng.annotations.Test;
import project.browser.Browser;
import project.driver.Driver;
import project.pages.MainPage;
import project.pages.PassportPage;
import project.pages.SearchPage;

public class TestCase_1 extends BaseTest{
    public static final String URL = "https://yandex.ru/";
    public static final String LOGIN = "unflesed7";
    public static final String PASSWORD = "11111111AAABBB";
    @Test
    public void correctPageLoaded() throws Exception {
        MainPage mainPage = new MainPage(Driver.getDriver());
        PassportPage passportPage = new PassportPage(Driver.getDriver());
        SearchPage searchPage = new SearchPage(Driver.getDriver());
        Browser browser = new Browser();

        Browser.getURL(URL);

        mainPage.closePopUp();

        Assert.assertTrue(mainPage.isOpened(), "Main page is not opened!");

        mainPage.clickEnterButton();

        Assert.assertTrue(passportPage.isPassportPageOpened(), "Passport page is not opened!");

        passportPage.inputLogin(LOGIN);
        passportPage.clickEnterButton();
        passportPage.waitUntilPasswordFormIsVisible();

        Assert.assertTrue(passportPage.isPasswordFormOpened(), "Password form is not opened!");

        passportPage.inputPassword(PASSWORD);
        passportPage.clickEnterButton();
        searchPage.waitUntilSearchPageIsOpened();

        Assert.assertTrue(searchPage.isOpened(), "Search page is not opened!");
        searchPage.clickAvatar();
        browser.switchToIframeByWebElement(searchPage.getIFrameXpath());

        Assert.assertEquals(searchPage.getLoginText(), LOGIN, "Text is not the same!");

    }

}
