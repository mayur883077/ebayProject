package TestPKG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

import POMClass.cartPage;
import POMClass.firstProductInfoPage;
import POMClass.homePage;
import POMClass.loginPage;
import POMClass.productPage;
import Utilclasses.ScreenRecorderUtil;
import baseClass.BaseClass;
import listenerClasess.listenerClass;

@Listeners(listenerClass.class)
public class verifyUserCanAddToCart {
	
	
		
		WebDriver driver;
		homePage hp;
		productPage pp;
		firstProductInfoPage fip;
		cartPage cp;
		loginPage lp;
		ExtentHtmlReporter htmlReporter;
		ExtentReports report;
		ExtentTest test;
		
		
		@BeforeClass
		public void beforeClass()
		{
			htmlReporter = new ExtentHtmlReporter("verifyUserCanAddToCart.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("verifyUserCanAddToCart");
			driver = BaseClass.getDriver("edge");
		}
		@BeforeMethod
		public void beforeMethod()
		{
			hp = new homePage(driver);
			pp = new productPage(driver);
			fip = new firstProductInfoPage(driver);
			cp = new cartPage(driver);
			lp = new loginPage(driver);
		}
		@Test
		public void productAddToCart() throws IOException, Exception
		{
			ScreenRecorderUtil.startRecord("productAddToCart");
			hp.enterText();
			pp.clickOnFirstProduct();
			fip.clickOnAddToCart();
			Assert.assertTrue(cp.cartProductName());
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


