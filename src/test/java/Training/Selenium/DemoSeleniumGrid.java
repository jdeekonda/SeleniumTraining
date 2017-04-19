package Training.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoSeleniumGrid {
	
  @Test(priority=7)
  public void Test_Normal(){
	  Assert.assertEquals(1,1, "In test which does not call Grid...");
	  System.out.println("In test which does not call Grid...");
  }
  
	
  @Test(priority=12)
  @Parameters({"GridNode"})
  public void Test_Grid(String GridNode) throws MalformedURLException {
	  System.out.println("In test which calls Grid...");
	  Assert.assertEquals(1,1, "In test which calls Grid...");
	  System.setProperty("webdriver.chrome.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\chromedriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  WebDriver driver = new RemoteWebDriver(new URL(GridNode),capabilities);

	  driver.get("https://www.ing.be/en/retail/lionaccount-salesflow?slp=1");
	//Explicit Wait technique
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#legalTitle")));
	  driver.quit();
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  Assert.assertTrue(true, "In Before test method...");
	  System.out.println("In Before test method...");
  }

  @AfterTest
  public void afterTest() {
	  Assert.assertTrue(true, "In After test method...");
	  System.out.println("In After test method...");
  }

}
