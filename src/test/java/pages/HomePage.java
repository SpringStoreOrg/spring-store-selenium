package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pageDriver.Element;
import pageDriver.Page;

import java.util.concurrent.TimeoutException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class HomePage extends Page {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    private final By userButton = By.id("userButton");
    private final By productCatalog = By.id("productCatalog");
    private final By signInButton = By.id("signIn");
    private final By signUpButton = By.id("signUp");
    private final By logoutButton = By.id("logout");
    private final By avatar = By.id("avatar");
    private final By favoriteIconBadge = By.id("favoriteIconBadge");

    private final By successSignUpMessage = By.id("signUpMsg");
    private final By productAddedToFavoritesMessage = By.id("addProdToFavMsg");
    private final By productRemovedFromFavoritesMessage = By.id("removeProdFromFavMsg");

    public void clickUserButton() {
        Element.click(driver.findElement(userButton));
    }

    public void clickSignInButton() {
        Element.click(driver.findElement(signInButton));
    }

    public void clickSignUpButton() {
        Element.click(driver.findElement(signUpButton));
    }

    public void clickFavoriteProductButton(int number) {

        Element.click(driver.findElement(By.id("select_fav_prod_" + number)));
    }

    public void clickRemoveFavoriteProductButton(int number) {

        Element.click(driver.findElement(By.id("unselect_fav_prod_" + number)));
    }

    public void clickLogoutButton() {
        Element.click(driver.findElement(logoutButton));
    }

    public void clickSuccessSignUpMessage() {
        Element.click(driver.findElement(successSignUpMessage));
    }

    public void clickProductAddedToFavoritesMessage() {
        Element.click(driver.findElement(productAddedToFavoritesMessage));
    }

    public void clickProductRemovedFromFavoritesMessage() {
        Element.click(driver.findElement(productRemovedFromFavoritesMessage));
    }

    public void checkProductCatalog() throws TimeoutException {
        assertTrue(driver.findElement(productCatalog).isDisplayed());
    }

    public void checkSuccessSignUpMessage() {
        assertTrue(Element.getText(successSignUpMessage, "Succesfully signed Up! Please confirm your Email!"));
    }

    public void checkProductAddedToFavoritesMessage() {
        assertTrue(Element.getText(productAddedToFavoritesMessage, "Product Added To Favorites!"));
    }

    public void checkProductRemovedFromFavoritesMessage() {
        assertTrue(Element.getText(productRemovedFromFavoritesMessage, "Product removed from Favorites!"));
    }

    public void checkAvatarLetters(String text) {
        assertTrue(Element.getText(avatar, text));
    }

    public void checkIsAvatarPresent() {
        assertFalse(Element.isElementPresent(avatar));
    }

    public void checkTextFavoriteIconBadge(String text) {
        assertTrue(Element.getText(favoriteIconBadge, text));
    }
}
