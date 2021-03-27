package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button_RadioButton_Checkbox {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		jsExecutor =(JavascriptExecutor) driver;
	}

	
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		By loginButton = By.cssSelector(".fhs-btn-login");
		
		//Verify button is disable
		Assert.assertFalse(driver.findElement(loginButton).isEnabled());
		
		driver.findElement(By.cssSelector("#login_username")).sendKeys("anhtran@gmai.com");
		driver.findElement(By.cssSelector("#login_password")).sendKeys("123456");
		
		//Verify button is Enabled
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		
		//Remove attribute "disabled" 
		
		removeDisableAttributeByJS(loginButton);
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());
		
		driver.findElement(loginButton).click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
		
	}
	public void removeDisableAttributeByJS(By by) {
		WebElement element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", element);
	}
	public void TC_02_RadioButton_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		//Select checkbox
		driver.findElement(By.xpath("//input[@value='Diabetes']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Diabetes']")).isSelected());
		
		//Neu khong co "value" thi xai:
		//label[contains(text(),'Diabetes')]/preceding-sibling::input
		//De-delect Checkbox
		driver.findElement(By.xpath("//input[@value='Diabetes']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Diabetes']")).isSelected());
		
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@class='form-checkbox']"));
		//Selecl all checkbox
			for (WebElement checkbox : allCheckbox) {
				checkbox.click();
			}	
			
		//Verify all checkbox
			for (WebElement checkbox : allCheckbox) {
				Assert.assertTrue(checkbox.isSelected());
			}
	}
	
	
	public void TC_03_Custom_RadioButton_Checkbox() {
	driver.get("https://material.angular.io/components/radio/examples");
	
	//The input khong click duoc nhung lai dung verify duoc
	//driver.findElement(By.xpath("//input[@value='Spring']")).click();
	//verify
	//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Spring']")).isSelected());
	
	//The Span click duoc nhung lai khong verify duoc
	//driver.findElement(By.xpath("//input[@value='Spring']/preceding-sibling::span[@class='mat-radio-outer-circle']")).click();
	//Verify
	//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Spring']")).isSelected());
	
	//Ket hop ca 2
	//driver.findElement(By.xpath("//input[@value='Spring']/preceding-sibling::span[@class='mat-radio-outer-circle']")).click();
	//Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Spring']")).isSelected());
	
	By springRadio = By.xpath("//input[@value='Spring']/preceding-sibling::span[@class='mat-radio-outer-circle']");
	
	clickByJS(springRadio);
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Spring']")).isSelected());
	}
	@Test
	public void TC_04_Custom_RadioButton_Checkbox_II() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		
		//Verify truoc khi click
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Đà Nẵng' and @ aria-checked='false' ]")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@data-value='Đà Nẵng']")).click();
		sleepInTime(2);
		
		//Verify sau khi click
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Đà Nẵng' and @ aria-checked='true' ]")).isDisplayed());

		
	}
	public void sleepInTime(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void clickByJS(By by) {
		WebElement element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].click();", element);
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
