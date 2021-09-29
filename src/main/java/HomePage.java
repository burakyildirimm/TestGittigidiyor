import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private Header header;
    final private By headerIdLocator = By.id("main-header");
    final private By cookiesCloseLocator = By.cssSelector("section.tyj39b-4 a.tyj39b-5");

    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public Header header() {
        return this.header;
    }

    public boolean isOpen() {
        return this.isDisplayed(headerIdLocator);
    }

    public void goToHomePage() {
        super.driver.get("https://www.gittigidiyor.com/");
        super.driver.manage().window().maximize();
    }

    public void acceptCookies() {
        if (super.isDisplayed(cookiesCloseLocator)) {
            click(cookiesCloseLocator);
        }
    }
}
