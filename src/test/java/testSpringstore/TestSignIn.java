package testSpringstore;

import com.google.gson.JsonObject;

import io.qameta.allure.Feature;
import org.testng.annotations.*;
import pageDriver.Page;
import pages.BasePage;
import testData.TestData;
import utility.ConfigFileReader;
import utility.Constants;

import static org.testng.Assert.assertEquals;
import static pageDriver.Page.driver;


public class TestSignIn extends BasePage {

    ConfigFileReader configReader = new ConfigFileReader();

    JsonObject userData;


    @BeforeSuite
    public void beforeTest()  {
        Constants.verificationError = new StringBuffer();
        userData = TestData.newSignInUserData();
    }
    @Feature("SignIn Successfully")
    @Test
    public void testSignInSuccessfully() {
        Page.navigateTo(configReader.getAppURL());
        assertEquals(Page.getTitle(), "Springwebstore");

        // Login
        Constants.verificationError.append(" :Browser open with success");

        homePage.clickUserButton();
        homePage.clickSignInButton();
        signInActions.signIn(userData.get("email").getAsString(),
                userData.get("password").getAsString());

        signInPage.clickSignInButton();

        // check Avatar letters after signed In.
        homePage.checkAvatarLetters("SC");

        //logout
        homePage.clickUserButton();
        homePage.clickLogoutButton();

        // check that Avatar letters are not displayed after signed Out.
        homePage.checkIsAvatarPresent();
    }

    @AfterSuite
    public static void browserClose() {
       Page.close();
    }

}
