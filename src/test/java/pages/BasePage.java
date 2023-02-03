package pages;

import actions.SignInActions;
import actions.SignUpActions;

public class BasePage {


    protected SignUpActions signUpActions = new SignUpActions();
    protected SignInActions signInActions = new SignInActions();

    protected HomePage homePage = new HomePage();
    protected SignUpPage signUpPage = new SignUpPage();
    protected SignInPage signInPage = new SignInPage();

}
