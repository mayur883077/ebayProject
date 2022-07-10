package POMClass;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class firstProductInfoPage extends utilClass{
	
WebDriver driver;
	
	@FindBy(xpath="//a[@id='isCartBtn_btn']")
	private WebElement addToCart;
	
	public firstProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}
	public void clickOnAddToCart()
	{
	explicitWait(driver, addToCart);
		addToCart.click();
	}

}


