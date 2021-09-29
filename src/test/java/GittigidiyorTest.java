import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class GittigidiyorTest extends BaseTest {

    @Test
    @Order(1)
    public void goToHomePage() {
        homePage.goToHomePage();
        homePage.acceptCookies();
        Assertions.assertTrue(homePage.isOpen(), "Not a home page!");
    }

    @Test
    @Order(2)
    public void goToLoginPage() {
        homePage.header().goToLoginPage();
        Assertions.assertTrue(loginPage.isOpen(), "Not a login page!");
    }

    @Test
    @Order(3)
    public void login() {
        loginPage.login("yildirimburakk34@gmail.com","12345678A");
        Assertions.assertTrue(loginPage.isLogin(), "Can not login with your information!");
    }

    @Test
    @Order(4)
    public void searchAProduct() {
        homePage.header().search("bilgisayar");
        Assertions.assertTrue(productsPage.isOpen(), "Problem occured while searching a product!");
    }

    @Test
    @Order(5)
    public void switchPageTo() {
        productsPage.switchTo(2);
        Assertions.assertTrue(productsPage.controlPageNumber(1), "Failed to change page!");
    }

    @Test
    @Order(6)
    public void selectRandomProduct() {
        productsPage.selectRandomProduct();
        Assertions.assertTrue(productDetailsPage.isOpen(), "The product could not be selected!");
    }

    @Test
    @Order(7)
    public void addToCart() {
        productDetailsPage.getProductDetails();
        productDetailsPage.addToCart();
        Assertions.assertTrue(productDetailsPage.header().checkoutProduct(), "The product failed to cart!");
    }

    @Test
    @Order(8)
    public void goToCartPage() {
        productDetailsPage.goToCartPage();
        Assertions.assertTrue(cartPage.isOpen(), "Not the cart page!");
    }


    @Test
    @Order(9)
    public void validateCartPrice() {
        Assertions.assertTrue(cartPage.validateCartPrice(), "Unfortunately, did not match the product prices of ...!");
    }

    @Test
    @Order(10)
    public void increaseQuantityTo() {
        cartPage.increaseQuantity(1);
        Assertions.assertTrue(cartPage.checkoutProductQuantity(), "Failed to increase product quantity!");
    }

    @Test
    @Order(11)
    public void deleteFromCart() {
        cartPage.deleteProduct();
        Assertions.assertTrue(cartPage.cartIsEmpty(), "Your cart is not empty!");
    }

}
