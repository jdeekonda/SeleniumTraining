package Training.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class FirstTest {

  public WebDriver driver;
	
  @Test
  public void filldata() {
	Select select = new Select(driver.findElement(By.cssSelector("#legalTitle")));

	select.selectByIndex(1);
		
	driver.findElement(By.cssSelector("#legalFirstName")).sendKeys("Eddy");
	
	driver.findElement(By.cssSelector("#legalLastName")).sendKeys("Merckx");
	
	driver.findElement(By.cssSelector("#birthdate_desktop")).sendKeys("17061945");
		
	driver.findElement(By.cssSelector("#birthplace")).sendKeys("brabant");
		
	select = new Select(driver.findElement(By.cssSelector("#nationality")));
		
	select.selectByVisibleText("Algerian");
		
	driver.findElement(By.cssSelector("#taxForeignCountryYes")).click();
		
	driver.findElement(By.cssSelector("#emailOptin")).click();
		
	driver.findElement(By.cssSelector("#noMobile")).click();	
	  
  }

  /*@DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }*/
  @BeforeTest
  public void beforeTest() {
	  
	System.setProperty("webdriver.chrome.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.ing.be/en/retail/lionaccount-salesflow?slp=1");
	//Implicit Wait
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("End of Test....");
	  driver.close();
  }

}
