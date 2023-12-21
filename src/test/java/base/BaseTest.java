package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        this.driver = WebDriverManager.chromedriver().create();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void stopDriver() {
        this.driver.quit();
    }
}
