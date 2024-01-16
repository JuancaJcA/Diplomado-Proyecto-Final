package createTripTA;

import com.aventstack.extentreports.Status;
import fastLoginTA.FastLoginTest;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.CreateTripTA;
import org.example.models.LoginTA;
import org.example.pages.TripsPageTA;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateTripTest extends FastLoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedDataProvider() throws FileNotFoundException {
        Object[] firstData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
        Object[] secondData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "createTrip.json", CreateTripTA.class);
        return JsonTestDataHelper.combinedDataProvider(firstData, secondData);
    }

    @Test(description = "Create a trip with the data provided in the json file.", dataProvider = "combinedDataProvider")
    public void createTripTest(LoginTA login, CreateTripTA createTrip) throws InterruptedException, IOException {
        // Call loginTest() from LoginTest class
        super.fastLoginTest(login);
        // Create trip test data
        ReportManager.getInstance().getTest().log(Status.INFO, "Create trip test data: " + createTrip.toString());
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarProfileIcon();
        navBarComponentTA.clickOnNavBarTripsOption();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The user is on the trips page.");
        // TripsPageTA actions
        TripsPageTA tripsPageTA = new TripsPageTA(driver);
        tripsPageTA.clickOnCreateOwnTripButton();
        tripsPageTA.fillCreateTripForm(createTrip.getTrip_name(), createTrip.getDestination());
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The trip name and destination have been entered correctly.");
        tripsPageTA.clickOnCreateTripButton();
        Assert.assertEquals(tripsPageTA.getTripCreatedName(), createTrip.getTrip_name());
        ReportManager.getInstance().getTest().log(Status.INFO, "Trip name test data: '" + createTrip.getTrip_name() + "' is equal to webpage trip name: '" + tripsPageTA.getTripCreatedName() + "'.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The trip has been created successfully.");
    }
}
