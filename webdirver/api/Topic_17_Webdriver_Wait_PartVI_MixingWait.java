package api;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_PartVI_MixingWait {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectFolder = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void beforeClass() {
		
	System.setProperty("webdriver.chrome.driver", projectFolder + "\\Browser\\chromedriver.exe" );
	
	driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
		
	}
	public void TC_01_Not_Found_Only_ImplicitWait() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("TC_1 Start " + getDateTimeSystem());
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký']")).isDisplayed());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Go to Catch");
			e.printStackTrace();
		}

		System.out.println("TC1_End " + getDateTimeSystem());
	}
	
	public void TC_02_Found_InplicitWait_ExplicitWait() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver,7);
		
		System.out.println("TC2_Start Implicit " + getDateTimeSystem());
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//button[@name='login']")).isDisplayed());
			
		} catch (Exception e) {		
			System.out.println("Go to Catch");
		}
		System.out.println("TC2_End Implicit " + getDateTimeSystem());
		
		System.out.println("TC2_Start Explicit " + getDateTimeSystem());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='login']")));
		} catch (Exception e) {
			
		}

		System.out.println("TC2_End Explicit " + getDateTimeSystem());	
	}
	
	public void TC_03_Not_Found_InplicitWait_ExplicitWait() {
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 7);
		
		System.out.println("TC3_Start Implicit " + getDateTimeSystem());
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//button[@name='anhtran_1996']")).isDisplayed());
			
		} catch (Exception e) {		
			
		}
		System.out.println("TC3_End Implicit " + getDateTimeSystem());
		
		System.out.println("TC3_Start Explicit " + getDateTimeSystem());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='anhtran1996']")));
		} catch (Exception e) {
			
		}
		
		System.out.println("TC3_End Explicit " + getDateTimeSystem());	
	}
	
	@Test
	public void TC_04_Not_Found_Only_ExplicitWait() {
		
		explicitWait = new WebDriverWait(driver, 5);
		
		System.out.println("TC4_Start Explicit " + getDateTimeSystem());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='anhtran1996']")));
		} catch (Exception e) {
			
		}
		
		System.out.println("TC5_End Explicit " + getDateTimeSystem());	
	}
	@Test
	public void TC_05_Not_Found_Only_ExplicitWait_WebElement() {
		
		explicitWait = new WebDriverWait(driver, 5);
		
		System.out.println("TC5_Start Explicit " + getDateTimeSystem());
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name='anhtran1996']"))));
		} catch (Exception e) {
			
		}
		
		System.out.println("TC5_End Explicit " + getDateTimeSystem());	
	}
	
	
	public String getDateTimeSystem() {
		Date date = new Date();
		return date.toString();
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
