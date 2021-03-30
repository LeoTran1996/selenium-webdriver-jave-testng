package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_User_Interactions_partI {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		
		driver = new FirefoxDriver();
		
		action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	public void TC_01_Hover_Mouse_Tooltip() {
		
		driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='ThemeRoller']"))).perform();
		
		sleepInTime(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(),"ThemeRoller: jQuery UI's theme builder application");
	}
	
	public void TC_02_Hover_Mouse() {
		
		driver.get("https://hn.telio.vn/");
		
		action.moveToElement(driver.findElement(By.xpath("//div[@class='content-top panel']//span[text()='Đồ uống']"))).perform();;
		
		sleepInTime(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='content-top panel']//a[text()='Cà phê']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='content-top panel']//a[text()='Trà']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='content-top panel']//a[text()='Bia']")).isDisplayed());

	}

	
	public void TC_03_Click_And_Hold() {
		
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		List<WebElement> allINumberToSelect = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		Assert.assertEquals(allINumberToSelect.size(), 12);
		
		action.clickAndHold(allINumberToSelect.get(0)).moveToElement(allINumberToSelect.get(3)).release().perform();
		
		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));

		Assert.assertEquals(allNumberSelected.size(), 4);
		
		for (WebElement numbers : allNumberSelected) {
			System.out.println(numbers.getText());
		} 

		sleepInTime(2);
	}
	
	public void TC_04_Click_And_Hold_Random() {
		
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		List<WebElement> allINumberToSelect = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		Assert.assertEquals(allINumberToSelect.size(), 12);
	
		//giu phim Control
		action.keyDown(Keys.CONTROL).perform();
		
		//chon cac so 2 7 9 11
		action.click(allINumberToSelect.get(1)).click(allINumberToSelect.get(6)).click(allINumberToSelect.get(8)).click(allINumberToSelect.get(10)).perform();
		
		//nha phim Control
		action.keyUp(Keys.CONTROL).perform();

		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));

		Assert.assertEquals(allNumberSelected.size(), 4);
		
		for (WebElement numbers : allNumberSelected) {
			System.out.println(numbers.getText());
		} 
		
	}
	
	@Test
	public void TC_05_Double_Click() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		
		sleepInTime(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
		
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
