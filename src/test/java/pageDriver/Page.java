package pageDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Page {

	public static WebDriver driver = BrowserInstance.readBrowser();

	public static void navigateTo(String pageURL)
	{
		driver.get(pageURL);
	}
	public static void close()
	{
		driver.quit();
	}

	public static String getTitle()
	{
		return driver.getTitle();
	}

	public static File takeScreenshot(String path){
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(path);
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return destFile;
	}


}
