package testSpringstore;

import com.google.gson.JsonObject;
import org.testng.annotations.*;
import pageDriver.Page;
import pages.BasePage;
import testData.TestData;
import utility.*;

import java.util.concurrent.TimeoutException;

import static org.testng.Assert.assertEquals;
import static pageDriver.Page.driver;


public class TestSignUp extends BasePage {

    ConfigFileReader configReader = new ConfigFileReader();

    JsonObject userData;

    @BeforeTest
    public void beforeTest()  {
        Constants.verificationError = new StringBuffer();
        userData = TestData.newSignUpUserData();
    }

    @Test
    public void testSignUpSuccessfully() throws TimeoutException {
        Page.navigateTo(configReader.getAppURL());
        assertEquals("Springwebstore", Page.getTitle());

        // Login
        Constants.verificationError.append(" :Browser open with success");

        homePage.clickUserButton();
        homePage.clickSignUpButton();

        signUpActions.signUp(userData.get("firstName").getAsString(),
                userData.get("lastName").getAsString(),
                userData.get("email").getAsString(),
                userData.get("phoneNumber").getAsString(),
                userData.get("deliveryAddress").getAsString(),
                userData.get("password").getAsString(),
                userData.get("confirmPassword").getAsString());

        signUpPage.clickSignUpButton();

        // Successfully Signed Up Toast message.
        homePage.checkSuccessSignUpMessage();
    }

    @AfterSuite
    public static void browserClose() {
        Page.close();
    }

}
