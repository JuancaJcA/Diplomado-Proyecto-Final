package logoutTA;

import com.aventstack.extentreports.Status;
import loginTA.LoginTest;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ScreenShotHelper;
import org.example.models.LoginTA;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LogoutTest extends LoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name="loginDataProvider")
    public Object[] loginDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
    }

    @Test(description = "Logout", dataProvider = "loginDataProvider")
    public void logoutTest(LoginTA login) throws InterruptedException, IOException {
        // Call loginTest() from LoginTest class
        super.loginTest(login);
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarProfileIcon();
        navBarComponentTA.clickOnNavBarSignOutButton();
        Assert.assertEquals(navBarComponentTA.getNavBarSignInButtonText(), "Sign in");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "The user could log out successfully.");
    }
}
