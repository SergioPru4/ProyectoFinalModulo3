package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
//    private final By product = By.xpath("//h4[a[text()='2017 Dell 15.6 Inch']]");
    private final By addToCart = By.xpath("//a[contains(@class, 'btn-success') and contains(@class, 'btn-lg') and contains(text(), 'Add to cart')]");
    private final By goCart = By.xpath("//a[@id='cartur']");
    private final By productTitle = By.xpath("//tbody[@id='tbodyid']/tr/td[2]");
    private final By productPrice = By.xpath("//tbody[@id='tbodyid']/tr/td[3]");
    private final By image = By.xpath("//div[@class='item active']/img");
    private final By imageCart = By.xpath("//tbody[@id='tbodyid']/tr/td/img");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void selectProduct(String productName) {
        driver.findElement(By.xpath("//h4[a[text()='"+productName+"']]")).click();
    }
    public void clickOnAddToCart() {
        driver.findElement(addToCart).click();
    }
    public void clickOnGoCart() {
        driver.findElement(goCart).click();
    }
    public String getProductTitleAndPrice() {
        return driver.findElement(productTitle).getText() + ":" + driver.findElement(productPrice).getText();
    }
    public void isDisplayedProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
    }
    public void isDisplayedProductCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageCart));
    }
}
