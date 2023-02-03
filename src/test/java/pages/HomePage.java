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
    private final By successSignUpMessageId = By.id("signUpMsg");
    private final By avatarId = By.id("avatar");
    private final By closeMsgButton = By.id("closeMsgButton");


    public void clickUserButton() {
        Element.click(driver.findElement(userButton));
    }

    public void clickSignInButton() {
        Element.click(driver.findElement(signInButton));
    }

    public void clickSignUpButton() {
        Element.click(driver.findElement(signUpButton));
    }

    public void clickLogoutButton() {
        Element.click(driver.findElement(logoutButton));
    }

    public void clickSuccessSignUpMessage() {
        Element.click(driver.findElement(successSignUpMessageId));
    }

    public void checkProductCatalog() throws TimeoutException {
        assertTrue(driver.findElement(productCatalog).isDisplayed());
    }

    public void checkSuccessSignUpMessage(String text) {
        assertTrue(Element.getText(successSignUpMessageId, text));
    }

    public void checkAvatarLetters(String text) {
        assertTrue(Element.getText(avatarId, text));
    }

    public void checkIsAvatarPresent() {
       assertFalse(Element.isElementPresent(avatarId));
    }

}
