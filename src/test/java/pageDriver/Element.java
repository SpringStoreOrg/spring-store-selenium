package pageDriver;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pageDriver.Page.driver;

public class Element {

    public static void checkElementIsDisplayed(WebElement element) throws TimeoutException {
        if (element.isDisplayed()) {
            System.out.println("Element is displayed");
        } else {
            throw new TimeoutException("Element is not displayed");
        }
    }

    public static void click(final WebElement element) {
        ElementErrorHandling.waitForElementPresent(element).click();
    }

    public static String getText(final WebElement element) {
        return ElementErrorHandling.waitForElementPresent(element).getText();
    }

    public static void enterText(final WebElement element, String value) {
        ElementErrorHandling.waitForElementEnabled(element).clear();
        ElementErrorHandling.waitForElementEnabled(element).sendKeys(value);
    }

    public static Boolean getText(final By element, String text) {
        return ElementErrorHandling.waitForTextPresent(element, text);
    }

    public static boolean isElementPresent(final By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
