package org.example.components;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarComponentTA extends BasePage {
    private final By signInButton = By.xpath("//div[text()='Sign in']");
    private final By profileIcon = By.xpath("//img[@alt='Profile picture']");
    private final By viewProfileOption = By.xpath("//span[text()='View profile']");
    private final By signOut = By.xpath("//span[text()='Sign out']");
    private final By tripsOption = By.xpath("//a[@id='menu-item-3' and @href='/Trips']");
    private final By discoverButton = By.xpath("//span[text()='Discover']");
    private final By travelForumsOption = By.id("menu-item-2");

    public NavBarComponentTA(WebDriver driver) {
        super(driver);
    }

    public void clickOnNavBarSignInButton() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(2000);
    }

    public void clickOnNavBarProfileIcon() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(profileIcon).click();
        Thread.sleep(2000);
    }

    public void clickOnNavBarViewProfileOption() throws InterruptedException {
        driver.findElement(viewProfileOption).click();
        Thread.sleep(2000);
    }

    public String getNavBarSignInButtonText() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(signInButton).getText();
    }

    public void clickOnNavBarSignOutButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(signOut).click();
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    public void clickOnNavBarTripsOption() throws InterruptedException {
        driver.findElement(tripsOption).click();
        Thread.sleep(2000);
    }

    public void clickOnNavBarDiscoverButton() throws InterruptedException {
        driver.findElement(discoverButton).click();
        Thread.sleep(2000);
    }

    public void clickOnNavBarTravelForumsOption() throws InterruptedException {
        driver.findElement(travelForumsOption).click();
        Thread.sleep(2000);
    }
}


