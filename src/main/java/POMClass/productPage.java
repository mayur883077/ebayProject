package POMClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class productPage extends utilClass {
	
	   WebDriver driver;
		
		@FindBy(xpath="(//h3[@class='s-item__title'])[2]")
		private WebElement clickOnProduct;
		@FindBy(xpath="//h3[@class='s-item__title']")
		private WebElement proList;
		
		public productPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;

		}
		public void clickOnFirstProduct()
		{
			explicitWait(driver, clickOnProduct).click();
			List<String> address = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(address.get(1));
		}
		public void listOfSearchProduct() throws IOException
		{
			explicitWait(driver, clickOnProduct);
			List <WebElement> product = driver.findElements(By.xpath("//h3[@class='s-item__title']"));
			product.size();
			for(int i=0; i<product.size(); i++)
			{
			writeDataInExcel(product.get(i).getText(), i, 2);
			
			}
		}
		

	}


