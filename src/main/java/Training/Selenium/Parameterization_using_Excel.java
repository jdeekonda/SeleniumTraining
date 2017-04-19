package Training.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parameterization_using_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	//Read test data from Excel
	InputStream inp = new FileInputStream("D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(inp);
	Sheet sheet = wb.getSheet("LionAccount");
	Row row = sheet.getRow(1);

	String Title = row.getCell(0).getStringCellValue();
	String Fname = row.getCell(1).getStringCellValue();
	String Lname = row.getCell(2).getStringCellValue();
	String DOB = row.getCell(3).getStringCellValue();
	String Nationality = row.getCell(4).getStringCellValue();
	String TaxStatus = row.getCell(5).getStringCellValue();	
	String EmailOption = row.getCell(6).getStringCellValue();
	String Mobile = row.getCell(7).getStringCellValue();
	
	//System.out.println(Title+"\n"+Fname+"\n"+Lname+"\n"+DOB+"\n"+Nationality+"\n"+TaxStatus+"\n"+EmailOption+"\n"+Mobile);
	
	System.setProperty("webdriver.chrome.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.get("https://www.ing.be/en/retail/lionaccount-salesflow?slp=1");

	//Explicit Wait technique
	WebDriverWait wait = new WebDriverWait(driver,15);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#legalTitle")));

	Select select = new Select(driver.findElement(By.cssSelector("#legalTitle")));
	select.selectByVisibleText(Title);
	
	driver.findElement(By.cssSelector("#legalFirstName")).sendKeys(Fname);
	driver.findElement(By.cssSelector("#legalLastName")).sendKeys(Lname);
	driver.findElement(By.cssSelector("#birthdate_desktop")).sendKeys(DOB);
	select = new Select(driver.findElement(By.cssSelector("#nationality")));
	select.selectByVisibleText(Nationality);
	
	if(TaxStatus.equals("Foreign"))
		driver.findElement(By.cssSelector("#taxForeignCountryYes")).click();
	else
		driver.findElement(By.cssSelector("#taxForeignCountryNo")).click();	
	
	if(EmailOption.equals("Yes"))
		driver.findElement(By.cssSelector("#emailOptin")).click();
	
	if(Mobile.equals("Yes"))
		driver.findElement(By.cssSelector("#noMobile")).click();
	
	}

}
