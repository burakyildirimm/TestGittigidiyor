import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    final private By loginFormLocator = By.id("gg-login-box");
    final private By mailInputLocator = By.id("L-UserNameField");
    final private By passwordInputLocator = By.id("L-PasswordField");
    final private By submitButtonLocator = By.id("gg-login-enter");

    private Header header;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public Header header() {
        return this.header;
    }

    public boolean isOpen() {
        return super.isDisplayed(this.loginFormLocator);
    }

    public void login(String mail, String pass) {
        super.find(mailInputLocator).sendKeys(mail);
        super.find(passwordInputLocator).sendKeys(pass);
        super.hover(submitButtonLocator);
        super.click(submitButtonLocator);
        super.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public boolean isLogin() {
        return this.header.userPanelContainer();
    }
}
