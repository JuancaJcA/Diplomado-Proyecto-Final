package createNewUserTA;

import com.aventstack.extentreports.Status;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.LoginTA;
import org.example.pages.HomePageTA;
import org.example.pages.ProfilePageTA;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

public class CreateNewUserTest extends BaseTest {
    public static String dataProviderPath = "resources/testdata/data/";
    public static String newUserEmail = "testTA" + System.currentTimeMillis() + "@gmail.com";

    @DataProvider(name = "dataProvider")
    public Object[] dataProvider() throws IOException, InterruptedException {
        // Update the user field in the json file
        JsonTestDataHelper.updateJsonFieldInFile(dataProviderPath + "login.json", "user", newUserEmail);
        return JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
    }

    @Test(description = "Create a new user updating the data provided in the json file.", dataProvider = "dataProvider")
    public void createNewUserTest(LoginTA login) throws InterruptedException, IOException {
        // HomePageTA actions
        HomePageTA homePageTA = new HomePageTA(driver);
        homePageTA.pressEscButton();
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarSignInButton();
        // HomePageTA actions
        homePageTA.clickOnContinueWithEmailButton();
        homePageTA.clickOnJoinButton();
        homePageTA.fillNewUserForm(login.getFirst_name(), login.getLast_name(), login.getUser(), login.getPassword());
        ReportManager.getInstance().getTest().log(Status.INFO, "New user data: " + login);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The new user data has been entered correctly.");
        homePageTA.clickOnCreateAccountButton();
        // NavBarComponentTA actions
        navBarComponentTA.clickOnNavBarProfileIcon();
        navBarComponentTA.clickOnNavBarViewProfileOption();
        // ProfilePageTA actions
        ProfilePageTA profilePageTA = new ProfilePageTA(driver);
        JsonTestDataHelper.updateJsonFieldInFile(dataProviderPath + "login.json", "user_id", profilePageTA.getUserId());
        ReportManager.getInstance().getTest().log(Status.INFO, "User_id test data file updated: '" + login.getUser_id() + ".");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The new user could be created successfully.");
    }
}
