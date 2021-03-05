package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_part2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void TC_01_ID() throws InterruptedException{
		driver.findElement(By.id("email")).sendKeys("Automaitonfc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		Thread.sleep(3000);
	}
	public void TC_02_Class() throws InterruptedException{
		//driver.navigate().refresh();
		driver.findElement(By.className("registered-users")).isDisplayed();
		Thread.sleep(3000);
		
	}
	public void TC_03_Name() throws InterruptedException{
		driver.findElement(By.name("login[username]")).sendKeys("123456");
		Thread.sleep(3000);
	}
	public void TC_04_Tagname(){
		System.out.println("Tong so link la: " + driver.findElements(By.tagName("a")).size());
	}
	public void TC_05_LinkText()
			throws InterruptedException{
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		Thread.sleep(3000);
		//lay text cua link tuyet doi(lay toan bo chuoi)
	}
	public void TC_06_Partial_LinkText() throws InterruptedException{ 
		driver.get("https://www.microsoft.com/vi-vn");
		driver.findElement(By.partialLinkText("Microsoft 36")).click();
		driver.findElement(By.partialLinkText("Hồ sơ tài")).click();
		Thread.sleep(3000);
	}
	//lay text cua link tuong doi(lay 1 phan chuoi).
	public void TC_07_Css_Selector() throws InterruptedException {
		driver.get("https://m.facebook.com/");
		driver.findElement(By.cssSelector("input[id='m_login_email']")).sendKeys("0358780054");
		Thread.sleep(3000);	
	}
	@Test
	public void TC_08_Xpath_Selector() {
		driver.get("https://m.facebook.com/");
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//div[@id='login_top_banner']")).isDisplayed();
		sleepInseconds(3);
	}
	
	public void sleepInseconds(long time) {
		try {
			Thread.sleep(time * 1000);
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