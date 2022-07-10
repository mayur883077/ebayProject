package TestPKG;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import POMClass.productPage;
import POMClass.registrationPage;
import Utilclasses.ScreenRecorderUtil;
import baseClass.BaseClass;
import listenerClasess.listenerClass;
@Listeners(listenerClass.class)
public class VerifyNewUserCanRegister {
	WebDriver driver;
	registrationPage rp ;
	productPage pp;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeClass
	public void beforeClass()
	{
		htmlReporter = new ExtentHtmlReporter("VerifyNewUserCanRegister.html");
	 report = new ExtentReports();
	report.attachReporter(htmlReporter);
	test = report.createTest("VerifyNewUserCanRegister");
		driver = BaseClass.getDriver("edge");
	}
	
	@BeforeMethod
	public void beforMethod() {
		rp= new registrationPage(driver);
		pp = new productPage(driver);
		
	}
	@Test
	public void userCanAddData() throws IOException, Exception {
		
		ScreenRecorderUtil.startRecord("userCanAddData");
		rp.clickOnRegister();
	//	Assert.assertTrue(rp.isOnRegistrationPage());
		rp.insertRegisterData();
		ScreenRecorderUtil.stopRecord();
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
	report.flush();
	driver.quit();
}
}
