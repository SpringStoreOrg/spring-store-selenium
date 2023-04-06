package actions;

import pages.SignInPage;

public class SignInActions {

    public void signIn(String email, String password) {
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
    }

}
