package Training.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoPriority {
	
	
  @Test(priority=0)
  public void TestwithP1() {
	  
	  System.out.println(" In Test without Grid");
	  Assert.fail("Fail first test");;
	  
  }
  
  @Test(priority=10)

  public void TestwithP2(String GridNode) throws MalformedURLException{
	  
	  System.out.println(" In Test with Grid");
	  //System.out.println(" Parameter found...."+Fname+" "+Lname);
	  Assert.assertTrue(true);
	  
	 //System.setProperty("webdriver.gecko.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\geckodriver.exe");
      
		
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("In beforeTest......");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In afterTest.....");
  }

}
