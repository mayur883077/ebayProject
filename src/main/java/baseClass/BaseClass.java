package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver getDriver(String k) {
			WebDriver driver = null;
			
			if (k.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
			}
			else if(k.equals("edge")) {
				WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			}
			driver.get("https://www.ebay.com/");
			driver.manage().window().maximize();
			return driver;
		}

}
