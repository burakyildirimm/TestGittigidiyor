import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    protected CartPage cartPage;

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("general.useragent.override", userAgent);
        driver = new ChromeDriver();

        homePage            = new HomePage(driver);
        loginPage           = new LoginPage(driver);
        productsPage        = new ProductsPage(driver);
        productDetailsPage  = new ProductDetailsPage(driver);
        cartPage            = new CartPage(driver);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterAll
    public void tearDown() {
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        driver.quit();
    }
}
