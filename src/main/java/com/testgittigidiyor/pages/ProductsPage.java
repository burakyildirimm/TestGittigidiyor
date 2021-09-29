package com.testgittigidiyor.pages;

import com.testgittigidiyor.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    final private By fiiltersObjLocator = By.className("pn44zy-0");
    final private By pageButtonsLocator = By.cssSelector("li.sc-12aj18f-2 a.sc-12aj18f-0 span");
    final private By productsLocator    = By.cssSelector("li.sc-1nx8ums-0 a");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void switchTo(int i) {
        Integer lastPage = this.getLastPageNumber();
        Assertions.assertTrue(this.pageCounter(i, lastPage), "Your destination page is contains incorrect value!");
        this.nextPageTo(i);
    }

    public boolean isOpen() {
        if(super.isDisplayed(fiiltersObjLocator)) {
            return true;
        } else {
            super.refreshPage();    // Because other tests should be continue!
            return false;
        }
    }

    public boolean controlPageNumber(int i) {
        if(super.isDisplayed(fiiltersObjLocator)) {
            return true;
        } else {
            super.refreshPage();    // Because other tests should be continue!
            return false;
        }
    }

    public void selectRandomProduct() {
        List<WebElement> elements = findAll(productsLocator);
        Integer elementSize = elements.size();
        Integer randomProduct = this.getRandomNumberOf(elementSize);
        WebElement element = elements.get(randomProduct);
        element.click();
    }


    private Integer getLastPageNumber() {
        List<WebElement> elements = findAll(pageButtonsLocator);
        Integer elementSize = elements.size();
        WebElement element = elements.get(elementSize - 1);
        Integer pageSize = Integer.parseInt(element.getText());
        return pageSize;
    }

    private boolean pageCounter(Integer currentPage, Integer pageSize) {
        return (pageSize >= currentPage) ? true : false;
    }

    private void nextPageTo(Integer page) {
        String url = super.driver.getCurrentUrl();
        String newUrl = url + "&sf=" + page;
        super.driver.get(newUrl);
    }

    private Integer getRandomNumberOf(Integer size) {
        Integer min = 0;
        Integer max = size - 1;
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }
}
