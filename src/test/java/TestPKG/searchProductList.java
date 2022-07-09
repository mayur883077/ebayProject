package TestPKG;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POMClass.homePage;
import POMClass.productPage;
import baseClass.BaseClass;
import listenerClasess.listenerClass;


@Listeners(listenerClass.class)
public class searchProductList {

		WebDriver driver;
		homePage hp;
		productPage pp;
		ExtentHtmlReporter htmlReporter;
		ExtentReports report;
		ExtentTest test;
		
		
		@BeforeClass
		public void beforeClass()
		{
			htmlReporter = new ExtentHtmlReporter("VerifyUserAddFunds.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("VerifyUserAddFund");
			driver = BaseClass.getDriver("edge");
		}
		@BeforeMethod
		public void beforeMethod()
		{
			hp= new homePage(driver);
			pp = new productPage(driver);
			
		}
		@Test
		public void searchList() throws IOException, Exception
		{
			hp.enterText();
			pp.listOfSearchProduct();
			
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, result.getName()+"test passed");
			}
			else if(result.getStatus()==ITestResult.FAILURE) {
				String path = pp.getScreenShot(driver, result.getName());
				test.log(Status.FAIL, result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
			else {
				test.log(Status.SKIP, result.getName()+"test skipped");
			}
			
		}
		
		
    @AfterClass
    public void afterClass() {
    	driver.quit();
    }
	}


