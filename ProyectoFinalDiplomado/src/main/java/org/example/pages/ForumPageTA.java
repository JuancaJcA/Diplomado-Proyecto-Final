package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ForumPageTA extends BasePage {
    private final By themeOnForum = By.xpath("//a[@class='BMQDV _F Gv wSSLS SwZTJ hNpWR w FGwzt ukgoS' and contains(text(),'Traveling with Pets')]");
    private final By topicOnForum = By.xpath("//a[contains(text(),'Any pet friendly accommodation in Tasmania?')]");
    private final By replyButton = By.xpath("//a[text()='Reply']");
    private final By commentBox = By.id("message");
    private final By postReplyButton = By.xpath("//input[@class='ui_button primary small' and @value='Post your reply']");

    public ForumPageTA(WebDriver driver) {
        super(driver);
    }

    public void clickOnThemeOption() throws InterruptedException {
        driver.findElement(themeOnForum).click();
        Thread.sleep(2000);
    }

    public void clickOnTopicOption() throws InterruptedException {
        driver.findElement(topicOnForum).click();
        Thread.sleep(2000);
    }

    public void clickOnReplyButton() throws InterruptedException {
        driver.findElement(replyButton).click();
        Thread.sleep(2000);
    }

    public void writeComment(String comment) throws InterruptedException {
        driver.findElement(commentBox).sendKeys(comment);
        Thread.sleep(2000);
    }

    public void clickOnPostReplyButton() throws InterruptedException {
        driver.findElement(postReplyButton).click();
        Thread.sleep(4000);
    }
}

