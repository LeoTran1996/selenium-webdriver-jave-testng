package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_Status_Element_PartI {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}

	
	public void TC_01_Element_Visible_Displayed() {
		
		// Dieu kien de 1 Element visible/displayed
		// + Element co tren UI(bat buoc)
		// + Element co trong DOM(bat buoc)
		// Wait My Account link at footer is displayed
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[text()='My Account']")));
		
		// Verify My Account link displayed
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).isDisplayed());
		
		// Click to Login button
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		// Wait Email message error is displayed
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='advice-required-entry-email']")));
		
		//Verify
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).isDisplayed());
	}
	
	@Test
	public void TC_02_Element_Invisible_Undisplayed_In_DOM() {
		driver.navigate().refresh();
		// Dieu kien de 1 Element invisible/undisplayed
		// + Element khong co tren UI(bat buoc)
		// + Element co trong DOM(Case 1)
	
		// Wait My Account link at header is Invisible/Undisplayed
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='advice-required-entry-email']")));
		
	}
	
	@Test
	public void TC_02_Element_Invisible_Undisplayed_Not_In_DOM() {
		driver.navigate().refresh();
		// Dieu kien de 1 Element invisible/undisplayed
		// + Element khong co tren UI(bat buoc)
		// + Element khong co trong DOM(Case2)
		
		//Wait Email error message is invisible/undisplayed
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='header-account']//a[text()='My Account']")));
	}
	
	

	@Test
	public void TC_03_Element_Presence() {
		
	}
	@Test
	public void TC_04_Element_Staleness() {
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
