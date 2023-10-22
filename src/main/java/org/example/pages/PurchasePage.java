package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PurchasePage extends BasePage{

    private final By placeOrder = By.xpath("//button[text()='Place Order']");
    private final By nameForm = By.id("name");
    private final By countryForm = By.id("country");
    private final By cityForm = By.id("city");
    private final By cardForm = By.id("card");
    private final By monthForm = By.id("month");
    private final By yearForm = By.id("year");
    private final By purchaseButton = By.xpath("//button[text()='Purchase']");
    private final By confirm = By.xpath("//h2[text()='Thank you for your purchase!']");


    public PurchasePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnPlaceOrder() {
        driver.findElement(placeOrder).click();
    }
    public void fillForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameForm).sendKeys(name);
        driver.findElement(countryForm).sendKeys(country);
        driver.findElement(cityForm).sendKeys(city);
        driver.findElement(cardForm).sendKeys(card);
        driver.findElement(monthForm).sendKeys(month);
        driver.findElement(yearForm).sendKeys(year);
    }
    public void clickOnPurchase() {
        driver.findElement(purchaseButton).click();
    }
    public String getConfirmText() {
        return driver.findElement(confirm).getText();
    }
    public void isDisplayedConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
    }
}

