package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage extends BasePage{
        private final By categoryLaptops = By.xpath("//a[text()='Laptops']");
        private final By product = By.xpath("//h4[a[text()='2017 Dell 15.6 Inch']]");

        private final By image =By.cssSelector(".card-img-top.img-fluid");

        public StorePage(WebDriver driver) {
            super(driver);
        }
        public void clickOnCategoryLaptops() {
            driver.findElement(categoryLaptops).click();
        }
        public void isDisplayedCategory() {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(product));
            wait.until(ExpectedConditions.visibilityOfElementLocated(image));

        }
}
