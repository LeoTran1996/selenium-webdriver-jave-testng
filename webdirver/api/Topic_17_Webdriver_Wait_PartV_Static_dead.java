package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_PartV_Static_dead {
	WebDriver driver;
	By startButton = By.xpath("//button[text()='Start']");
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
	}
	@Test
	public void TC_01_Less_Than() {
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(startButton).click();
		sleepInSeconds(3);
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
				
		
	}
	@Test
	public void TC_02_Greater_Than_or_Equal() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(startButton).click();
		sleepInSeconds(7);
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
				
		
	}

	public void sleepInSeconds(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
