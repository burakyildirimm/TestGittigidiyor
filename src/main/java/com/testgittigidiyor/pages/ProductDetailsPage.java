package com.testgittigidiyor.pages;

import com.testgittigidiyor.modules.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends BasePage {

    private static String productName  = "";
    private static int productQuantity = 0;
    private static String productPrice = "";

    private Header header;
    final private By basketButtonLocator = By.id("add-to-basket");
    final private By productNameLocator  = By.id("sp-subTitle");
    final private By productPriceLocator = By.id("sp-price-lowPrice");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public Header header() {
        return this.header;
    }

    public boolean isOpen() {
        return super.isDisplayed(this.basketButtonLocator);
    }

    public void addToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        super.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        super.click(basketButtonLocator);
    }

    public void getProductDetails() {
        super.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement nameElement = super.find(productNameLocator);
        ProductDetailsPage.productName = nameElement.getText();

        WebElement priceElement = super.find(productPriceLocator);
        ProductDetailsPage.productPrice = priceElement.getText();

        System.out.println(ProductDetailsPage.productPrice);
    }

    public static String getProductPrice() {
        return ProductDetailsPage.productPrice;
    }

    public static String getProductName() {
        return ProductDetailsPage.productName;
    }

    public static int getProductQuantity() {
        return ProductDetailsPage.productQuantity;
    }

    public void goToCartPage() {
        this.header.goToCartPage();
    }

}
