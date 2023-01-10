package pageDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constants;

public class ElementErrorHandling {
    public static WebDriver driver = BrowserInstance.driver;

    public static boolean verifyElementPresent(final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (NoSuchElementException | NoSuchWindowException | NoSuchFrameException e) {
            Constants.verificationError.append("Element exception: " + e);
            return false;
        }
    }

    public static WebElement waitForElementPresent(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | NoSuchWindowException | NoSuchFrameException e) {
            Constants.verificationError.append("Element exception: " + e);
        }
        return element;
    }

    public static WebElement waitForElementEnabled(final WebElement usernameField) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        } catch (NoSuchElementException | NoSuchWindowException | NoSuchFrameException e) {
            Constants.verificationError.append("Element exception: " + e);
        }
        return usernameField;
    }

}
