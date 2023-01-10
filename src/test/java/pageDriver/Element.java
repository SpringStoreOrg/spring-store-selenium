package pageDriver;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;

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
}
