package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pageDriver.Element;
import pageDriver.Page;

public class SignUpPage extends Page {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    private By userButton = By.id("userButton");
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("email");
    private By phoneNumberInput = By.id("phoneNumber");
    private By deliveryAddressInput = By.id("deliveryAddress");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By signUpButton = By.id("signUpButton");
    private By successSignUpMessageId = By.id("signUpMsg");

    public void clickUserButton() {
        Element.click(driver.findElement(userButton));
    }

    public void enterFirstName(String firstName) {
        Element.enterText(driver.findElement(firstNameInput), firstName);
    }

    public void enterLastName(String lastName) {
        Element.enterText(driver.findElement(lastNameInput), lastName);
    }

    public void enterEmail(String email) {
        Element.enterText(driver.findElement(emailInput), email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        Element.enterText(driver.findElement(phoneNumberInput), phoneNumber);
    }

    public void enterDeliveryAddress(String deliveryAddress) {
        Element.enterText(driver.findElement(deliveryAddressInput), deliveryAddress);
    }

    public void enterPassword(String password) {
        Element.enterText(driver.findElement(passwordInput), password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        Element.enterText(driver.findElement(confirmPasswordInput), confirmPassword);
    }

    public void clickSignUpButton() {
        Element.click(driver.findElement(signUpButton));
    }

}
