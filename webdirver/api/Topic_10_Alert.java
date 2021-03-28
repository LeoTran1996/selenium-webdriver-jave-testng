package api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Alert {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Alert alert;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		jsExecutor = (JavascriptExecutor) driver;
	}
	
	public void TC_01_Accept_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		sleepInTime(2);
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
		
		//Accept
		
		//Cancel
		
		//Input value
		
		//Get title
		
	}
	
	public void TC_02_Confirm_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		sleepInTime(2);
		
		alert.dismiss();
		
		sleepInTime(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
		
	}
	
	public void TC_03_Prompt_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");

		String alerText = "AnhTran1996";
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		sleepInTime(2);
		
		alert.sendKeys(alerText);
		
		alert.accept();
		
		sleepInTime(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: " + alerText );
		
		
	}
	

	public void TC_04_Authentication_Alert() {
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		//driver.get("http://username:password@the-internet.herokuapp.com/basic_auth");
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		//Password contain special characters e.g: P@ssword!
		//Xai encode html
		driver.get("http://admin:P%40ssword%21@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}

	public void TC_05_Authentication_Alert_Click_To_A_Link() {
		driver.get("http://the-internet.herokuapp.com/");
		
		String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		//http://the-internet.herokuapp.com/basic_auth
		
		driver.get(getCredentialtoURL(url, "admin", "admin"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		
	}
	
	@Test
	public void TC_06_Authentication_Alert_AutoIT() throws IOException {
		String rootFolder = System.getProperty("user.dir");
		
		
		String firefoxAuthen = rootFolder + "\\Auto_IT\\authen_firefox.exe";
		
		Runtime.getRuntime().exec(new String[] { firefoxAuthen, "admin", "admin" });
	
		driver.get("http://the-internet.herokuapp.com/basic_auth");

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

	}
	
	public String getCredentialtoURL(String url, String username, String password) {
		String[] newUrl = url.split("//");
		url = newUrl[0] + "//" + username + ":" + password + "@" + newUrl[1];
		return url;
	}
	public void sleepInTime(long time) {
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
