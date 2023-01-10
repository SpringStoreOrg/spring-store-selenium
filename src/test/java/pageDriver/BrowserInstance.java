package pageDriver;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ConfigFileReader;
import utility.Constants;

public class BrowserInstance {

    public static WebDriver driver;

    public static WebDriver readBrowser() {
        ConfigFileReader configReader = new ConfigFileReader();
        String browserName = configReader.getBrowserName();

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--window-size=1920,1200");
            driver = new ChromeDriver(options);
            return driver;
        } else
            return buildFirefoxDriver();
    }

    public static WebDriver buildFirefoxDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }

}
