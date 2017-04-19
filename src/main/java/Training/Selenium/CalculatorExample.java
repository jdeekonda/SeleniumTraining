package Training.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculatorExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.ie.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		WebDriver driver = new InternetExplorerDriver(ieCapabilities);
	
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("http://www.calculator.net/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#hcalc > table > tbody > tr > td:nth-child(2) > div:nth-child(3) > a")).click();
		
		driver.findElement(By.cssSelector("#content > ul:nth-child(5) > li:nth-child(3) > a")).click();	
		
		driver.findElement(By.id("cpar1")).sendKeys("15");
		
		driver.findElement(By.id("cpar2")).sendKeys("500");		
		
		driver.findElement(By.cssSelector("#content > table:nth-child(4) > tbody > tr:nth-child(2) > td > input[type=\"image\"]:nth-child(2)")).click();
		
		List <WebElement> Result = driver.findElements(By.cssSelector("#content > p.verybigtext"));
		
		if(Result.isEmpty())
			System.out.println("No Result found on webpage");
		else
			System.out.println("Result text is....."+Result.get(0).getText());
		
		driver.close();

	}

}
