package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageTA extends BasePage {
    private final By userId = By.cssSelector("span.Dsdjn._R");
    private final By threeDots = By.xpath("/html/body/div[2]/div/div/div[3]/div[3]/div[2]/div/div/div/div/div/div[1]/div/div/div[1]");
    private final By deleteCommentOption = By.xpath("//span[text()='Delete']");
    private final By deleteCommentButton = By.xpath("//button[text()='Delete']");

    public ProfilePageTA(WebDriver driver) {
        super(driver);
    }

    public String getUserId() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(userId).getText();
    }

    public void clickOnThreeDots() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(threeDots).click();
        Thread.sleep(3000);
    }

    public void clickOnDeleteCommentOption() throws InterruptedException {
        driver.findElement(deleteCommentOption).click();
        Thread.sleep(3000);
    }

    public void clickOnDeleteCommentButton() throws InterruptedException {
        driver.findElement(deleteCommentButton).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

}

