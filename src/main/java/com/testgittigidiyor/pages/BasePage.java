package com.testgittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void type(By locator, String text) {
        this.find(locator).sendKeys(text);
    }

    public void click(By locator) {
        this.find(locator).click();
    }

    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.find(locator)).perform();
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
    }
}