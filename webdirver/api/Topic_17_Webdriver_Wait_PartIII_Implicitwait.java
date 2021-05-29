package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_PartIII_Implicitwait {
	WebDriver driver;
	By startButton = By.xpath("//button[text()='Start']");
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		

	}
	@Test
	public void TC_01_Less_Than() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(startButton).click();
		//0.5s
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
				
		
	}
	@Test
	public void TC_02_Greater_Than_or_Equal() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(startButton).click();
		//0.5s
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
				
		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
