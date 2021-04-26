package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Iframe_Frame {
	WebDriver driver;
	Select select;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TestCase_01() {
		driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");

		// Switch vao frame

		// Index
		// driver.switchTo().frame(4);

		// ID or Name
		// driver.switchTo().frame("");

		// Web Element

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Facebook Social Plugin')]")));

		// hoac //div[@class="fb-page fb_iframe_widget"]//iframe

		String CountLike = driver
				.findElement(By.xpath("//a[@title=\"Automation FC\"]/parent::div/following-sibling::div")).getText();
		System.out.println(CountLike);

		// Default Content

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[text()='KHÓA HỌC SELENIUM AUTOMATION TESTING']")).isDisplayed());
	}

	@Test
	public void TestCase_02() {
		driver.get("https://kyna.vn/");

		// Switch vao Chat Iframe

		driver.switchTo().frame("cs_chat_iframe");

		driver.findElement(By.xpath("//div[@class=\"border_overlay meshim_widget_widgets_BorderOverlay\"]")).click();

		// driver.findElement(By.cssSelector("div.favicon")).click();

		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Anh Tran");
		
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0358780055");
		
		select = new Select(driver.findElement(By.id("serviceSelect")));
		
		select.selectByVisibleText("HỖ TRỢ KỸ THUẬT");
		
		driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Newaccount");
		
		sleepInTime(3);
		driver.findElement(By.xpath("//input[@value=\"Gửi tin nhắn\"]")).click();
		sleepInTime(3);
		//Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'logged_in_name')]")).getText(), "Anh Tran");
		//Assert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'logged_in_phone']")).getText(), "0358780055");
		//Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='message']")).getText(), "New account");
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(@class,'logged_in_name') and text()='Anh Tran']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(@class,'logged_in_phone') and text()='0358780055']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//textarea[@name='message' and text()='Newaccount']")).isDisplayed());
		sleepInTime(3);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
		driver.findElement(By.className("search-button")).click();
		
		List<WebElement> excelText = driver.findElements(By.cssSelector(".content>h4"));
		for (WebElement text : excelText) {
			Assert.assertTrue(text.getText().contains("Excel"));
		}
	}

	@Test
	public void TestCase_03() {

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
