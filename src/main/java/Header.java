import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Header extends BasePage {

    final private By profileButtonLocator = By.className("gekhq4-5");
    final private By loginButtonLocator = By.cssSelector("div.sc-12t95ss-3");
    final private By userPanelContainerLocator = By.cssSelector("div.fui1s9-0");
    final private By searchBoxLocator = By.cssSelector("input.sc-4995aq-0");
    final private By searchButtonLocator = By.cssSelector("button.qjixn8-0");
    final private By myCartButtonLocator = By.cssSelector("div.basket-container");
    final private By myCartProductCountLocator = By.cssSelector("div.basket-icon-container .notify-user");
    final private By myCartEmptyLocator = By.cssSelector("div.ciohle-11");
    final private By myUserNameLocator = By.cssSelector("div.gekhq4-4");
    final private By myProductCartsPrice = By.cssSelector("#header-cart-item-494835573 > div.product-description.gg-d-18 > p.product-price > span");
    final private By homePageLocator = By.cssSelector("a.logo_gg");

    public Header(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        super.hover(profileButtonLocator);
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        super.click(loginButtonLocator);
    }

    public void search(String s) {
        this.goToHomePage();
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        super.hover(searchBoxLocator);
        super.type(searchBoxLocator, s);
        super.click(searchButtonLocator);
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean checkoutProduct() {
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        return super.isDisplayed(myCartProductCountLocator);
    }

    public void clearCart() {
    }

    public boolean cartIsEmpty() {
        return false;
    }

    public boolean userPanelContainer() {
//        super.hover(profileButtonLocator);
        return this.userNameBlockController();
    }

    private boolean userNameBlockController() {
        String staticBlock = "Giriş Yap";
        if ( find(this.myUserNameLocator).getText() == staticBlock ) {
            return false;
        } else {
            return true;
        }
    }

    private String getLastCartProductPrice() {
        List<WebElement> elements = findAll(myProductCartsPrice);
        WebElement lastElement = elements.get(elements.size() - 1);
        By strong = By.cssSelector("strong");
        WebElement priceElement = lastElement.findElement(strong);
        String lastPrice = priceElement.getText();

        return lastPrice;
    }

    private void goToHomePage() {
        click(homePageLocator);
    }

    public void goToCartPage() {
        click(myCartButtonLocator);
    }

}
