package testSpringstore;

import com.google.gson.JsonObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageDriver.BrowserInstance;
import pageDriver.Element;
import pageDriver.Page;
import pages.BasePage;
import pages.HomePage;
import testData.TestData;
import utility.*;

import java.io.IOException;
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
        userData = TestData.newSignInUserData();
    }

    @Test
    public void testSignUpSuccessfully() throws TimeoutException, InterruptedException {
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

        WebDriverWait wait = new WebDriverWait(BrowserInstance.driver, 30000);
        By signUpMessageId = By.id("signUpMsg");
        boolean isDisplayed = wait.until(
                ExpectedConditions.textToBe(signUpMessageId, "Succesfully signed Up! Please confirm your Email!"));
        assertTrue("Succesfully signed Up visible", isDisplayed);

        // Succesfully Signed Up Toast message.
        //assertTrue(homePage.getSuccessSignUpMessage().contains("Succesfully signed Up! Please confirm your Email!"));

    }

    @AfterClass
    public static void browserClose() {
        // driver.quit();
        Page.close();
    }

}
