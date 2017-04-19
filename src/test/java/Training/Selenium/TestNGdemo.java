package Training.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNGdemo {
	
  @Test(priority=0)
  public void Test1() {
	  String message = "testNG";
	  Assert.assertEquals(message, "testNG");
  }
  
  @Test(priority=10)
  public void Test2() {
	  String message = "testNG";
	  Assert.assertEquals(message, "testNGx"); 
  }
  
  @Test(priority=5)
  public void Test3() {
	  Assert.fail();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("In BeforTest method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("In AfterTest method");
  }

}
