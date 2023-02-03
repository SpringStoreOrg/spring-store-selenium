package actions;

import pages.SignInPage;
import pages.SignUpPage;

import java.util.concurrent.TimeoutException;

public class SignInActions {

    public void signIn(String email, String password) {
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
    }

}
