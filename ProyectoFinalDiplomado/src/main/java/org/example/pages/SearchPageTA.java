package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageTA extends BasePage {
    // Search bar results
    private final By searchedResult = By.cssSelector("span[class='title-query']");

    public SearchPageTA(WebDriver driver) {
        super(driver);
    }

    public String getSearchedResult() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(searchedResult).getText();
    }
}

