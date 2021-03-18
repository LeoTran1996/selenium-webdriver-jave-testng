package api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Method_part_3_exercise_4 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test

	public void TC_04_isDisplayed() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.cssSelector("#email")).sendKeys("anhtran@gmail.com");
		driver.findElement(By.cssSelector("#new_username")).sendKeys("anhtran");

		// lowercase character
		driver.findElement(By.cssSelector("#new_password")).sendKeys("auto");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		// uppercase character
		driver.findElement(By.cssSelector("#new_password")).clear();
		driver.findElement(By.cssSelector("#new_password")).sendKeys("Auto");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		// number
		driver.findElement(By.cssSelector("#new_password")).clear();
		driver.findElement(By.cssSelector("#new_password")).sendKeys("1234");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		// special character
		driver.findElement(By.cssSelector("#new_password")).clear();
		driver.findElement(By.cssSelector("#new_password")).sendKeys("@@!!");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		// 8 characters minimum
		driver.findElement(By.cssSelector("#new_password")).clear();
		driver.findElement(By.cssSelector("#new_password")).sendKeys("Antr@1");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		// valid
		driver.findElement(By.cssSelector("#new_password")).clear();
		driver.findElement(By.cssSelector("#new_password")).sendKeys("Anhtran@123");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
