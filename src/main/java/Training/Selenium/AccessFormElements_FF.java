package Training.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class AccessFormElements_FF {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\geckodriver.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette", true);
		//capabilities.setBrowserName("firefox");
		//capabilities.setPlatform(Platform.ANY);
		//capabilities.setCapability("firefox_binary", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
	
		
		driver.get("https://www.ing.be/en/retail/lionaccount-salesflow?slp=1");
		
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
		Select select = new Select(driver.findElement(By.cssSelector("#legalTitle")));

		select.selectByIndex(1);
		
		driver.findElement(By.cssSelector("#legalFirstName")).sendKeys("Eddy");
		
		driver.findElement(By.cssSelector("#legalLastName")).sendKeys("Merckx");
	
		driver.findElement(By.cssSelector("#birthdate_desktop")).sendKeys("17061945");
		
		driver.findElement(By.cssSelector("#birthplace")).sendKeys("brabant");
		
		select = new Select(driver.findElement(By.cssSelector("#nationality")));
		
		select.selectByVisibleText("Algerian");
		
		List<WebElement> RadioButtons = driver.findElements(By.cssSelector("input[name=\"taxForeignCountry\"]"));
		
		System.out.println("Number of radio button...."+RadioButtons.size());
		
		RadioButtons.get(1).click();
		
		//driver.findElement(By.cssSelector("#taxForeignCountryYes")).click();
		
		driver.findElement(By.cssSelector("#emailOptin")).click();
		
		driver.findElement(By.cssSelector("#noMobile")).click();		

		driver.close();
	}

}
