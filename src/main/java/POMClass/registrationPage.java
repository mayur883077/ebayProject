package POMClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class registrationPage extends utilClass {
	
	WebDriver driver;
	@FindBy(xpath = "//a[text()='register']")
	private  WebElement register;
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastName;
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailID;
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	@FindBy(xpath="//button[@id='EMAIL_REG_FORM_SUBMIT']")
	private WebElement clickOnRegisterButton;
	@FindBy(xpath = "//input[@value=\"personalaccount\"]")
	private WebElement radioButton;
	
	
	public registrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void clickOnRegister() {
		explicitWait(driver, register).click();
	}
	
	public Boolean isOnRegistrationPage() {
		WebElement ele =explicitWait(driver, firstName);
		return ele.isSelected();
	}
	public void insertRegisterData() throws IOException, Exception {
		WebElement ele =explicitWait(driver, firstName);
		ele.sendKeys(getExcelData(0, 0));
		lastName.sendKeys(getExcelData(1, 0));
		emailID.sendKeys(getExcelData(2, 0));
		password.sendKeys(getExcelData(3, 0));
		Thread.sleep(1000);
		explicitWait(driver, clickOnRegisterButton).click();
	
		
		
		
	}
}
