package Utilclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilClass {
	 static Workbook src;
	 static Sheet sheet;
	
	public static String getExcelData(int j,int k) throws Exception, IOException {
		FileInputStream file = new FileInputStream("src\\main\\resources\\TestData\\ebayData.xlsx");
		
		 src= WorkbookFactory.create(file);
		
		 sheet = src.getSheet("Sheet1");
		String data = sheet.getRow(j).getCell(k).getStringCellValue();
		return data;
	}	
	 public static Sheet writeDataInExcel() throws IOException {
		FileOutputStream file1 = new FileOutputStream("src\\main\\resources\\TestData\\ebayData.xlsx");
		src.write(file1);
		 sheet = src.getSheet("Sheet2");

		 return sheet;
		 
	}
		
		
	
 public static WebElement explicitWait(WebDriver driver, WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
	return element;
 }
 
 public String getScreenShot(WebDriver driver,String Testname) throws IOException {
		
		SimpleDateFormat Frt = new SimpleDateFormat("dd-mm-yyyy-hh--mm");
		String date = Frt.format(new Date());
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = Testname+".png";
		File Desti =  new  File(path);
		
		org.openqa.selenium.io.FileHandler.copy(source, Desti);
		return path;
	}
 
}
