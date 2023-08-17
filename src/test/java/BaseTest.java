import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import project.browser.Browser;
import project.driver.Driver;

public abstract class BaseTest {
    @BeforeMethod
    public void getDriver() throws Exception {
        Driver.getDriver();
        Browser.setBrowserConfig();
    }

    @AfterMethod
    public void quit(){
        Driver.quit();
    }

}
