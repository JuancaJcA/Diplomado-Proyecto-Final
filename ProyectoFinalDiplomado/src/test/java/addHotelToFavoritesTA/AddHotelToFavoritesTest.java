package addHotelToFavoritesTA;

import com.aventstack.extentreports.Status;
import fastLoginTA.FastLoginTest;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.HotelTA;
import org.example.models.LoginTA;
import org.example.pages.HomePageTA;
import org.example.pages.HotelPageTA;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddHotelToFavoritesTest extends FastLoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedDataProvider() throws FileNotFoundException {
        Object[] firstData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
        Object[] secondData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "addHotel.json", HotelTA.class);
        return JsonTestDataHelper.combinedDataProvider(firstData, secondData);
    }

    @Test(description = "Add a hotel to favorites with the data provided in the json file.", dataProvider = "combinedDataProvider")
    public void addHotelToFavoritesTest(LoginTA login, HotelTA hotel) throws InterruptedException, IOException {
        // Call loginTest() from LoginTest class
        super.fastLoginTest(login);
        // Hotel test data
        ReportManager.getInstance().getTest().log(Status.INFO, "Hotel test data: " + hotel.toString());
        // HomePageTA actions
        HomePageTA homePageTA = new HomePageTA(driver);
        homePageTA.searchHotelInAllSearchBar(hotel.getHotel_name());
        ReportManager.getInstance().getTest().log(Status.INFO, "Hotel: " + hotel.getHotel_name() + " searched successfully");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The hotel has been searched successfully.");
        homePageTA.clickOnHotelSearchResult();
        // HotelPageTA actions
        HotelPageTA hotelPageTA = new HotelPageTA(driver);
        hotelPageTA.clickOnAddToFavoritesButton();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Saving hotel to favorites.");
        hotelPageTA.clickOnCreateTripButton();
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarProfileIcon();
        navBarComponentTA.clickOnNavBarTripsOption();
        Assert.assertEquals("Trip to Mumbai", hotel.getTrip_name());
        ReportManager.getInstance().getTest().log(Status.INFO, "Trip name test data: '" + hotel.getTrip_name() + "' is equal to webpage trip name: 'Trip to Mumbai'");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The trip has been created successfully.");
    }
}
