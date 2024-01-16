package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripsPageTA extends BasePage {
    private final By createOwnTripButton = By.xpath("//span[text()='Create your own trip']");
    private final By tripNameInput = By.xpath("//input[@placeholder='e.g., Summer vacation in Greece']");
    private final By destinationInput = By.xpath("//input[@placeholder='Where to?']");
    private final By createTripButton = By.xpath("//span[text()='Create']");
    private final By destinationNameOption = By.xpath("//div[text()='Lazio, Italy']");

private final By tripCreatedName = By.xpath("//div[text()='The best trip ever']");


    public TripsPageTA(WebDriver driver) {
            super(driver);
        }

    public void clickOnCreateOwnTripButton() throws InterruptedException {
        driver.findElement(createOwnTripButton).click();
        Thread.sleep(3000);
    }

    public void fillCreateTripForm(String tripName, String destination) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(tripNameInput));
        driver.findElement(tripNameInput).sendKeys(tripName);
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationInput));
        driver.findElement(destinationInput).sendKeys(destination);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationNameOption));
        driver.findElement(destinationNameOption).click();
        Thread.sleep(2000);
    }

    public void clickOnCreateTripButton() throws InterruptedException {
        driver.findElement(createTripButton).click();
        Thread.sleep(3000);
    }

    public String getTripCreatedName() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(tripCreatedName).getText();
    }
}


