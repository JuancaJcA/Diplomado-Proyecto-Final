package fastLoginTA;

import com.aventstack.extentreports.Status;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.LoginTA;
import org.example.pages.HomePageTA;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FastLoginTest extends BaseTest {
    public static String loginTestDataProviderPath = "resources/testdata/data/";

    @DataProvider(name="dataProvider")
    public Object[] dataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(loginTestDataProviderPath + "login.json", LoginTA.class);
    }

    @Test(description = "Log in data entry and verify that both the username and password have been entered correctly.", dataProvider = "dataProvider")
    public void fastLoginTest(LoginTA login) throws IOException, InterruptedException {
        // HomePageTA actions
        HomePageTA homePageTA = new HomePageTA(driver);
        homePageTA.pressEscButton();
        // NabBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarSignInButton();
        // HomePageTA actions
        homePageTA.clickOnContinueWithEmailButton();
        ReportManager.getInstance().getTest().log(Status.INFO, "Login test data: " + login.toString());
        homePageTA.fillEmailAndPasswordForm(login.getUser(), login.getPassword());
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The user and password have been entered correctly.");
        homePageTA.clickOnSignInButton();
    }
}
