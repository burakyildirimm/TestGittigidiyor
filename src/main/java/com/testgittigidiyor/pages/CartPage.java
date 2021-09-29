package com.testgittigidiyor.pages;

import com.testgittigidiyor.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    final private By completeShoppingBlockLocator   = By.cssSelector("div.right-box-content");
    final private By myProductCartsPrice            = By.tagName("strong");
    final private By amountSelectorLocator          = By.cssSelector("select.amount");
    final private By trashLocator                   = By.cssSelector("a.btn-delete.btn-update-item");
    final private By emptyCartInfoLocator           = By.cssSelector("div.empty-cart-info");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return isDisplayed(completeShoppingBlockLocator);
    }

    public boolean validateCartPrice() {
        String productPrice = (ProductDetailsPage.getProductPrice()).trim();
        System.out.println("ürün fiyatı:  " + productPrice);
        String cartPrice = (findAll(myProductCartsPrice).get(0).getText()).trim();
        System.out.println("Sepet fiyatı:  " + cartPrice);
        return cartPrice != productPrice;
    }


    public void increaseQuantity(int quantity) {
        this.selectQuantity(quantity);
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void selectQuantity(int ind) {
        Select amount = new Select(find(amountSelectorLocator));
        amount.selectByIndex(ind);
    }

    public boolean checkoutProductQuantity() {
        Select select = new Select(find(amountSelectorLocator));
        WebElement option = select.getFirstSelectedOption();
        String selected = option.getText();

        return selected != "1";
    }

    public void deleteProduct() {
        super.click(trashLocator);
        super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean cartIsEmpty() {
        return super.isDisplayed(emptyCartInfoLocator);
    }
}