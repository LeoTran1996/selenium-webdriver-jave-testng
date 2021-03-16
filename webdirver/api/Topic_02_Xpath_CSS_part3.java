package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_part3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Login_Empty_Email_And_Password() {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("login[password]")).sendKeys("");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),
				"This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),
				"This is a required field.");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("anhtran.abc@123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_03_Login_With_Invalid_Password() {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("anhtran1996@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),
				"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void TC_04_Login_with_Icorrect_Email_And_Password() {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("anhtran1996@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),
				"Invalid login or password.");
		sleepInsecond(2);

	}
	public void sleepInsecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	@Test
	public void TC_05_ID() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}