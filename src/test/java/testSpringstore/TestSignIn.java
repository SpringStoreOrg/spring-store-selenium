package testSpringstore;

import com.google.gson.JsonObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pageDriver.Page;
import pages.BasePage;
import testData.TestData;
import utility.ConfigFileReader;
import utility.Constants;
import utility.TestReport;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;


public class TestSignIn extends BasePage {

    ConfigFileReader configReader = new ConfigFileReader();

    JsonObject userData;

    @Rule
    public TestReport testReport = new TestReport();

    @Before
    public void beforeTest()  {
        Constants.verificationError = new StringBuffer();
        userData = TestData.newSignInUserData();
    }

    @Test
    public void testSignUpSuccessfully() {
        Page.navigateTo(configReader.getAppURL());
        assertEquals("Springwebstore", Page.getTitle());

        // Login
        Constants.verificationError.append(" :Browser open with success");

        homePage.clickUserButton();
        homePage.clickSignInButton();
        signInActions.signIn(userData.get("email").getAsString(),
                userData.get("password").getAsString());

        signInPage.clickSignInButton();

        // check Avatar letters after signed In.
        homePage.checkAvatarLetters("JF");
    }


    @AfterClass
    public static void browserClose() {
        // driver.quit();
        Page.close();
    }

}
