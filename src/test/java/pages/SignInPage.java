package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pageDriver.Element;
import pageDriver.Page;

public class SignInPage extends Page {

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("signInButton");

    public void enterEmail(String email) {
        Element.enterText(driver.findElement(emailInput), email);
    }

    public void enterPassword(String password) {
        Element.enterText(driver.findElement(passwordInput), password);
    }

    public void clickSignInButton() {
        Element.click(driver.findElement(signInButton));
    }
}
