package actions;

import pages.SignUpPage;

import java.util.concurrent.TimeoutException;

public class SignUpActions {

    public void signUp(String firstName, String lastName, String email, String phoneNumber, String deliveryAddress, String password, String confirmPassword) throws TimeoutException {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterDeliveryAddress(deliveryAddress);
        signUpPage.enterPassword(password);
        signUpPage.enterConfirmPassword(confirmPassword);
    }

}
