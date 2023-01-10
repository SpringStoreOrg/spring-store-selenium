package utility;

import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageDriver.Page;


public class TestReport extends TestWatcher {

	 private ExtentHtmlReporter htmlReporter;
	    public TestReport() {
	    }
	    @Override
	    protected void failed(Throwable e, Description description) {
	    	String path = System.getProperty("user.dir") + "/target/" + description.getDisplayName()+"_"+Util.getDateTime()+".png";
	    	Page.takeScreenshot(path);

	        ExtentReports extent = createReport();
	        ExtentTest test = extent.createTest("FAILED: "+description.getDisplayName(), "Test failed, click here for further details");

	        try {
				test.info("Screenshot attached").addScreenCaptureFromPath(path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        test.info("Errors"+Constants.verificationError.toString());
	        test.log(Status.FAIL, "Failure trace Selenium: "+ e.toString());
	        flushReports(extent, test);
	    }
	    //When passed only write to the log.
	    @Override
	    protected void succeeded(Description description) {
	        ExtentReports extent = createReport();
	        ExtentTest test = extent.createTest(description.getDisplayName(), "-");
	        test.log(Status.PASS, "PASSED: "+description.getDisplayName());
	        flushReports(extent, test);
	    }
	    private ExtentReports createReport() {
	        ExtentReports extent = new ExtentReports();
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/target/" +"\\ExtentReportResults.html");
	        extent.attachReporter(htmlReporter);
	        return extent;
	    }
	    private void flushReports(ExtentReports extent, ExtentTest test){
	        // writing everything to document
	        extent.flush();
	    }
}
