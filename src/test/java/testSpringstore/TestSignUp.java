package testSpringstore;

import com.google.gson.JsonObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pageDriver.Page;
import pages.BasePage;
import testData.TestData;
import utility.*;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestSignUp extends BasePage {

    ConfigFileReader configReader = new ConfigFileReader();

    JsonObject userData;

    @Rule
    public TestReport testReport = new TestReport();

    @Before
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


        // Succesfully Signed Up Toast message.
        homePage.checkSuccessSignUpMessage("Succesfully signed Up! Please confirm your Email!");
    }


    @AfterClass
    public static void browserClose() {
        // driver.quit();
        Page.close();
    }

}
