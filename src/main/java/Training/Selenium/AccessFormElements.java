package Training.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessFormElements {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\chromedriver.exe");

		//System.setProperty("webdriver.ie.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\IEDriverServer.exe");

		//System.setProperty("webdriver.gecko.driver", "D:\\Users\\jdeekond\\Documents\\Selenium\\Setups\\IEDriverServer.exe");

		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new InternetExplorerDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.ing.be/en/retail/lionaccount-salesflow?slp=1");
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
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

		//driver.close();
	}

}
