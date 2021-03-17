package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic05_Element_Method_part_1_exercise {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void TC_01_isDisplayed() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");	
			
	}
	@Test
	public void TC_02_isEnabled() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");	
			
	}
	@Test
	public void TC_03_isSelected() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");	
			
	}
	@Test
	public void TC_04_isDisplayed() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");	
			
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
