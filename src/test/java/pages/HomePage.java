package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pageDriver.Element;
import pageDriver.Page;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertTrue;

public class HomePage extends Page {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    private By userButton = By.id("userButton");
    private By productCatalog = By.id("productCatalog");
    private By signInButton = By.id("signIn");
    private By signUpButton = By.id("signUp");
    private By successSignUpMessageId = By.id("signUpMsg");

    public void clickUserButton()  {
        Element.click(driver.findElement(userButton));
    }

    public void clickSignInButton() {
        Element.click(driver.findElement(signInButton));
    }

    public void clickSignUpButton() {
        Element.click(driver.findElement(signUpButton));
    }

    public void checkProductCatalog() throws TimeoutException {
       assertTrue(driver.findElement(productCatalog).isDisplayed());
    }

    public String getSuccessSignUpMessage() {
        return Element.getText(driver.findElement(successSignUpMessageId));
    }


}
