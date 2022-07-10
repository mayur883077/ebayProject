package POMClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class loginPage extends utilClass  {
WebDriver driver;
@FindBy(xpath="//a[text()='Sign in']")
private WebElement signInButton;
@FindBy(xpath="//input[@id= 'userid']")
private WebElement userID;
@FindBy(xpath="//button[@id='signin-continue-btn']")
private WebElement Continue;
@FindBy(xpath="//input[@id='pass']")
private WebElement password;
@FindBy(xpath="//button[@id='sgnBt']")
private WebElement clickOnSign;


public loginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver =driver;
}

public void clickOnSignIn() {
	explicitWait(driver, signInButton).click();
}

public void insertData() throws IOException, Exception {
	explicitWait(driver, userID).sendKeys(getExcelData(2, 0));
	Thread.sleep(1000);
	Continue.click();
	explicitWait(driver, password).sendKeys(getExcelData(3, 0));
	clickOnSign.click();
	
}
	
	
}