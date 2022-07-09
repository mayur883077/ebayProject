package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class cartPage extends utilClass {

	WebDriver driver;
		
		@FindBy(xpath="//span[@class='BOLD']")
		private WebElement isVisible;
		
		public cartPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;

		}
		public String cartProductName()
		{
			explicitWait(driver, isVisible);
			return isVisible.getText();
		}

	}

