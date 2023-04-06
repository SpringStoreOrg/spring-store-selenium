package testSpringstore;

import com.google.gson.JsonObject;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageDriver.Page;
import pages.BasePage;
import testData.TestData;
import utility.ConfigFileReader;
import utility.Constants;

import static org.testng.Assert.assertEquals;


public class TestAddAndRemoveProductToFavorites extends BasePage {

    ConfigFileReader configReader = new ConfigFileReader();

    JsonObject userData;

    @BeforeTest
    public void beforeTest() {
        Constants.verificationError = new StringBuffer();
        userData = TestData.newSignInUserData();
    }

    @Feature("Add And Remove Product To Fav Successfully")
    @Test
    public void testAddAndRemoveProductToFavSuccessfully() {
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

        // Add first product to favorites
        homePage.clickFavoriteProductButton(0);
        homePage.checkProductAddedToFavoritesMessage();
        homePage.clickProductAddedToFavoritesMessage();

        // check that favorite icon badge contains value 1
        homePage.checkTextFavoriteIconBadge("1");

        // Remove first product to favorites
        homePage.clickRemoveFavoriteProductButton(0);
        homePage.checkProductRemovedFromFavoritesMessage();
        homePage.clickProductRemovedFromFavoritesMessage();

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
