package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelPageTA extends BasePage {
    private final By addToFavoritesButton = By.xpath("//button[@class='BrOJk u j z _F wSSLS HuPlH unMkR' and @data-automation='trips-save-button-item-302179']");
    private final By createTripButton = By.xpath("//span[text()='Create']");

    public HotelPageTA(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToFavoritesButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToFavoritesButton));
        driver.findElement(addToFavoritesButton).click();
        Thread.sleep(3000);
    }

    public void clickOnCreateTripButton() throws InterruptedException {
        driver.findElement(createTripButton).click();
        Thread.sleep(2000);
    }
}

