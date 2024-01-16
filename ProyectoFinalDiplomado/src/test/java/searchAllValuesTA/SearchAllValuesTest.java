package searchAllValuesTA;

import com.aventstack.extentreports.Status;
import fastLoginTA.FastLoginTest;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.LoginTA;
import org.example.models.SearchTA;
import org.example.pages.HomePageTA;
import org.example.pages.SearchPageTA;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchAllValuesTest extends FastLoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedDataProvider() throws FileNotFoundException {
        Object[] firstData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
        Object[] secondData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "search.json", SearchTA.class);
        return JsonTestDataHelper.combinedDataProvider(firstData, secondData);
    }

    @Test(description = "Search hotels, things to do, restaurants and vacation rentals on search bar.", dataProvider = "combinedDataProvider")
    public void searchAllValuesTest(LoginTA login, SearchTA search) throws IOException, InterruptedException {
        // Call loginTest() from LoginTest class
        super.fastLoginTest(login);
        // HomePageTA actions
        HomePageTA homePageTA = new HomePageTA(driver);
        // Search PageTA actions
        SearchPageTA searchPageTA = new SearchPageTA(driver);
        // Search test data
        ReportManager.getInstance().getTest().log(Status.INFO, "Search test data: " + search.toString());
        // Search Hotel
        homePageTA.clickOnHotelOption();
        homePageTA.searchInBarHotelInput(search.getHotel());
        Assert.assertEquals(search.getHotel(), searchPageTA.getSearchedResult());
        ReportManager.getInstance().getTest().log(Status.INFO, "Hotel: " + search.getHotel() + " searched successfully");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The searched values are equal to: " + search.getHotel());
        homePageTA.clickOnTripAdvisorLogo();
        // Search Things to do
        homePageTA.clickOnThingsToDoOption();
        homePageTA.searchInBarThingsToDoInput(search.getThings_to_do());
        Assert.assertEquals(search.getThings_to_do(), searchPageTA.getSearchedResult());
        ReportManager.getInstance().getTest().log(Status.INFO, "Things to do: " + search.getThings_to_do() + " searched successfully");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The searched values are equal to: " + search.getThings_to_do());
        homePageTA.clickOnTripAdvisorLogo();
        // Search Restaurants
        homePageTA.clickOnRestaurantsOption();
        homePageTA.searchInBarRestaurantsInput(search.getRestaurant());
        Assert.assertEquals(search.getRestaurant(), searchPageTA.getSearchedResult());
        ReportManager.getInstance().getTest().log(Status.INFO, "Restaurant: " + search.getRestaurant() + " searched successfully");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The searched values are equal to: " + search.getRestaurant());
        homePageTA.clickOnTripAdvisorLogo();
        // Search Vacation Rentals
        homePageTA.clickOnVacationRentalsOption();
        homePageTA.searchInBarVacationRentalsInput(search.getVacation_rental());
        Assert.assertEquals(search.getVacation_rental(), searchPageTA.getSearchedResult());
        ReportManager.getInstance().getTest().log(Status.INFO, "Vacation rental: " + search.getVacation_rental() + " searched successfully");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The searched values are equal to: " + search.getVacation_rental());
    }
}
