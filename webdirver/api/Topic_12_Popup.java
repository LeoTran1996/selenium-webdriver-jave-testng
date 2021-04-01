package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Popup {
	WebDriver driver;
	Actions action;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action =new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	public void TC_01_Popup_Fixed() {
		
		driver.get("https://tiki.vn/");
		
		//Hover
		action.moveToElement(driver.findElement(By.xpath("//img[@class='profile-icon']"))).perform();
		
		//Click dang nhap
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		
		//kiem tra popup displayed
		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='dialog']/div")).isDisplayed());
		
		//click close icon
		driver.findElement(By.xpath("//span[@class='tikicon icon-circle-close']")).click();
		
		
		//Sau khi close, Element con trong DOM
		//Assert.assertFalse(driver.findElement(By.xpath("//div[@role='dialog']/div")).isDisplayed());
	}
	
	public void TC_02_Popup_In_DOM() {
		
		driver.get("https://bni.vn/");
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
		
	
		driver.findElement(By.xpath("//img[@class='sgpb-popup-close-button-1']")).click();
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());
		
	}
	
	@Test
	public void TC_02_Popup_In_DOM_Condition() throws InterruptedException {
		
		//Step1
		System.out.println("Step 1");
		
		driver.get("https://blog.testproject.io/");
		Thread.sleep(10000);
	
		if(driver.findElement(By.xpath("//div[@class='mailch-wrap']")).isDisplayed()) {
			System.out.println("Step 2");
			driver.findElement(By.xpath("//div[@id='close-mailch']")).click();		
			Thread.sleep(3000);
		}
			
		System.out.println("Step 3");
		driver.findElement(By.xpath("//section[@id='search-2']//input[@class='search-field']")).sendKeys("hihi");;
		Thread.sleep(3000);
	}
	
	
	
	public void TC_03_LoginFormDisplayed() {
driver.get("https://tiki.vn/");
		
		//Hover
		action.moveToElement(driver.findElement(By.xpath("//img[@class='profile-icon']"))).perform();
		
		//Click dang nhap
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		
		//kiem tra popup displayed
		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='dialog']/div")).isDisplayed());
		
		//click close icon
		driver.findElement(By.xpath("//span[@class='tikicon icon-circle-close']")).click();
	
		//kiem tra
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']/div")).size(), 0);
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
