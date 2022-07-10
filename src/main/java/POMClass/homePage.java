package POMClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class homePage extends utilClass {
	WebDriver driver;
	@FindBy(xpath="//b[text()='Ramdas']")
	private WebElement userName;
    @FindBy(xpath="//input[@type='text']")
	private WebElement inputText;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement enterButton;
	@FindBy(xpath="(//h3[@class='s-item__title'])[2]")
	private WebElement clickOnProduct;
	
	
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
public Boolean isSuccessfullyLogin() throws IOException, Exception {
	
explicitWait(driver, userName);
	return userName.isDisplayed();

}
public void enterText() throws IOException, Exception
{
	explicitWait(driver,inputText);
	inputText.sendKeys(getExcelData(0, 1));
	enterButton.click();
	
}

}
