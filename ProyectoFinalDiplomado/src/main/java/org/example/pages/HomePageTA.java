package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageTA extends BasePage {
    // Login
    private final By iFrame = By.xpath("//iframe[contains(@src, '/RegistrationController?flow=sign_up_and_save')]");
    private final By continueWithEmailButton = By.xpath("//span[text()='Continue with email']");
    private final By emailInput = By.id("regSignIn.email");
    private final By passwordInput = By.id("regSignIn.password");
    private final By signInButton = By.xpath("//button[@type='submit']");
    // Sign up
    private final By joinButton = By.xpath("//span[text()='Join']");
    private final By firstNameInput = By.id("regSignUp.firstName");
    private final By lastNameInput = By.id("regSignUp.lastName");
    private final By emailSignUpInput = By.id("regSignUp.email");
    private final By passwordSignUpInput = By.xpath("//input[@name='password']");
    private final By createAccountButton = By.id("regSignUp.submit");
    // Search bar inputs
    private final By searchBarAllInput = By.xpath("//input[@placeholder='Places to go, things to do, hotels...']");
    private final By searchBarHotelInput = By.xpath("//input[@placeholder='Hotel name or destination']");
    private final By searchBarThingsToDoInput = By.xpath("//input[@placeholder='Attraction, activity or destination']");
    private final By searchBarRestaurantsInput = By.xpath("//input[@placeholder='Restaurant or destination']");
    private final By searchBarVacationRentalsInput = By.xpath("//input[@placeholder='Destination']");
    // Search bar options
    private final By searchBarHotelOption = By.xpath("//a[@class='CdXAG Vm C-' and text()='Hotels']");
    private final By searchBarThingsToDoOption = By.xpath("//a[@class='CdXAG Vm C-' and text()='Things to Do']");
    private final By searchBarRestaurantsOption = By.xpath("//a[@class='CdXAG Vm C-' and text()='Restaurants']");
    private final By searchBarVacationRentalsOption = By.xpath("//a[@class='CdXAG Vm C-' and text()='Vacation Rentals']");
    // Search bar results
    private final By hotelSearchAllResult = By.xpath("//div[text()='Mumbai, India']");
    // TripAdvisor Logo
    private final By tripAdvisorLogo = By.xpath("//img[@class='XpHHt'][@src='https://static.tacdn.com/img2/brand_refresh/Tripadvisor_lockup_horizontal_secondary_registered.svg'][@alt='Tripadvisor']");


    public HomePageTA(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinueWithEmailButton() throws InterruptedException {;
        driver.switchTo().frame(driver.findElement(iFrame));
        driver.findElement(continueWithEmailButton).click();
        Thread.sleep(1000);
    }

    public void fillEmailAndPasswordForm(String email, String password) throws InterruptedException {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickOnSignInButton() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(1000);
    }

    public void clickOnJoinButton() throws InterruptedException {
        driver.findElement(joinButton).click();
        Thread.sleep(2000);
    }

    public void fillNewUserForm(String firstName, String lastName, String email, String password) throws InterruptedException {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailSignUpInput).sendKeys(email);
        driver.findElement(passwordSignUpInput).sendKeys(password);
        Thread.sleep(2000);
    }

    public void clickOnCreateAccountButton() throws InterruptedException {
        driver.findElement(createAccountButton).click();
        Thread.sleep(2000);
    }

    public void searchHotelInAllSearchBar(String searchQuery) throws InterruptedException {
        driver.findElement(searchBarAllInput).sendKeys(searchQuery);
        Thread.sleep(2000);
    }

    public void searchInBarHotelInput(String searchQuery) throws InterruptedException {
        driver.findElement(searchBarHotelInput).sendKeys(searchQuery + Keys.ENTER);
        Thread.sleep(2000);
    }

    public void searchInBarThingsToDoInput(String searchQuery) throws InterruptedException {
        driver.findElement(searchBarThingsToDoInput).sendKeys(searchQuery + Keys.ENTER);
        Thread.sleep(2000);
    }

    public void searchInBarRestaurantsInput(String searchQuery) throws InterruptedException {
        driver.findElement(searchBarRestaurantsInput).sendKeys(searchQuery + Keys.ENTER);
        Thread.sleep(2000);
    }

    public void searchInBarVacationRentalsInput(String searchQuery) throws InterruptedException {
        driver.findElement(searchBarVacationRentalsInput).sendKeys(searchQuery + Keys.ENTER);
        Thread.sleep(2000);
    }

    public void clickOnHotelSearchResult() throws InterruptedException {
        driver.findElement(hotelSearchAllResult).click();
        Thread.sleep(4000);
    }

    public void clickOnHotelOption() throws InterruptedException {
        driver.findElement(searchBarHotelOption).click();
        Thread.sleep(2000);
    }

    public void clickOnThingsToDoOption() throws InterruptedException {
        driver.findElement(searchBarThingsToDoOption).click();
        Thread.sleep(2000);
    }

    public void clickOnRestaurantsOption() throws InterruptedException {
        driver.findElement(searchBarRestaurantsOption).click();
        Thread.sleep(2000);
    }

    public void clickOnVacationRentalsOption() throws InterruptedException {
        driver.findElement(searchBarVacationRentalsOption).click();
        Thread.sleep(2000);
    }

    public void clickOnTripAdvisorLogo() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(tripAdvisorLogo).click();
        Thread.sleep(2000);
    }

    public void pressEscButton() throws InterruptedException {
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }
}
