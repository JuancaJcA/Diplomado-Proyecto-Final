package postCommentOnForumTA;

import com.aventstack.extentreports.Status;
import fastLoginTA.FastLoginTest;
import org.example.components.NavBarComponentTA;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.ForumTA;
import org.example.models.LoginTA;
import org.example.pages.ForumPageTA;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PostCommentOnForumTest extends FastLoginTest {
    public static String dataProviderPath = "resources/testdata/data/";

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedDataProvider() throws FileNotFoundException {
        Object[] firstData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "login.json", LoginTA.class);
        Object[] secondData = JsonTestDataHelper.getInstance().getTestData(dataProviderPath + "forum.json", ForumTA.class);
        return JsonTestDataHelper.combinedDataProvider(firstData, secondData);
    }

    @Test(description = "Post a comment in the forum.", dataProvider = "combinedDataProvider")
    public void postCommentOnForumTest(LoginTA login, ForumTA forum) throws InterruptedException, IOException {
        // Call loginTest() from LoginTest class
        super.fastLoginTest(login);
        // Forum test data
        ReportManager.getInstance().getTest().info("Forum test data: " + forum.toString());
        // NavBarComponentTA actions
        NavBarComponentTA navBarComponentTA = new NavBarComponentTA(driver);
        navBarComponentTA.clickOnNavBarDiscoverButton();
        navBarComponentTA.clickOnNavBarTravelForumsOption();
        ReportManager.getInstance().getTest().info("Navigated to Travel Forums page.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Travel Forums option clicked successfully");
        // ForumPageTA actions
        ForumPageTA forumPageTA = new ForumPageTA(driver);
        forumPageTA.clickOnThemeOption();
        forumPageTA.clickOnTopicOption();
        forumPageTA.clickOnReplyButton();
        forumPageTA.writeComment(forum.getComment());
        forumPageTA.clickOnPostReplyButton();
        ReportManager.getInstance().getTest().info("The comment " + forum.getComment() + " was posted successfully on topic " + forum.getTopic() + ".");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Comment posted successfully");
    }
}
