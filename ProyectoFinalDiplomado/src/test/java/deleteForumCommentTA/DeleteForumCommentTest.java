package deleteForumCommentTA;

import com.aventstack.extentreports.Status;
import fastLoginTA.FastLoginTest;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.LoginTA;
import org.example.pages.ProfilePageTA;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DeleteForumCommentTest extends FastLoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name="loginDataProvider")
    public Object[] loginDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
    }

    @Test(description = "Delete a comment in the forum.", dataProvider = "loginDataProvider")
    public void deleteForumCommentTest(LoginTA login) throws InterruptedException, IOException {
        // Call loginTest() from LoginTest class
        super.fastLoginTest(login);
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarProfileIcon();
        navBarComponentTA.clickOnNavBarViewProfileOption();
        ReportManager.getInstance().getTest().info("Navigated to Profile page.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Profile page");
        // ProfilePageTA actions
        ProfilePageTA profilePageTA = new ProfilePageTA(driver);
        profilePageTA.clickOnThreeDots();
        profilePageTA.clickOnDeleteCommentOption();
        profilePageTA.clickOnDeleteCommentButton();
        ReportManager.getInstance().getTest().info("Comment deleted.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Comment deleted successfully");
    }
}
