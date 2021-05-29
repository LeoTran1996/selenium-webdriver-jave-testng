package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_PartIV_Explicitlywait {
	WebDriver driver;
	By startButton = By.xpath("//button[text()='Start']");
	By loadingIcon = By.xpath("//div[@id='loading']");
	By helloWorldText = By.xpath("//div[@id='finish']/h4");
	
	String projectPath = System.getProperty("user.dir");
	
	String nameimg1 = "vananh123.jpg";
	String nameimg2 = "vananh456.jpg";
	
	String path1996 = projectPath +  "\\Update_File\\" + nameimg1;
	String path1997 = projectPath +  "\\Update_File\\" + nameimg2;
	
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",projectPath + "\\Browser\\chromedriver.exe" );
		driver =new ChromeDriver();
	}

	public void TC_01_Loading_Icon_Invisible_10s() {
		explicitWait = new WebDriverWait(driver, 10);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(startButton).click();
		
		//Cho cho den khi loading icon bien mat trong vong 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		
		Assert.assertEquals(driver.findElement(helloWorldText).getText(), "Hello World!");
				
		
	}

	public void TC_02_Loading_Icon_Invisible_4s() {
		explicitWait = new WebDriverWait(driver, 4);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(startButton).click();
		
		//Cho cho den khi loading icon bien mat trong vong 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		
		Assert.assertEquals(driver.findElement(helloWorldText).getText(), "Hello World!");
				
	}
	
	public void TC_03_Hello_Text_Visible_10s() {
		explicitWait = new WebDriverWait(driver, 10);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(startButton).click();
		
		//Cho cho den khi loading icon bien mat trong vong 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloWorldText));
		
		Assert.assertEquals(driver.findElement(helloWorldText).getText(), "Hello World!");
				
	}
	
	public void TC_04_Hello_Text_Visible_4s() {
		explicitWait = new WebDriverWait(driver, 4);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(startButton));
		driver.findElement(startButton).click();
		
		//Cho cho den khi loading icon bien mat trong vong 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloWorldText));
		
		Assert.assertEquals(driver.findElement(helloWorldText).getText(), "Hello World!");
				
	}
	
	public void TC_05_Select_Date() {
		
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		explicitWait = new WebDriverWait(driver, 10);

		WebElement selectedDate = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']"));
		
		Assert.assertEquals(selectedDate.getText(), "No Selected Dates to display.");
		
		//Cho ngay 3 co the duoc kich vao hay khong 
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='3']/parent::td"))).click();
		
		//Cho cho Ajax loading bien mat
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']")));
		
		//Cho cho ngay 3 da duoc chon
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='3']/parent::td[@class='rcSelected']")));
		
		selectedDate = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']"));
		
		Assert.assertEquals(selectedDate.getText(), "Monday, May 3, 2021");
		
	}
	@Test
	public void TC_06_Upload() {
		
		driver.get("https://filebin.net/");
		
		explicitWait = new WebDriverWait(driver, 10);
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		uploadFile.sendKeys( path1996 + "\n" + path1997);
		
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector(".progress"))));
	
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + nameimg1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + nameimg2 + "']")).isDisplayed());
		
	}
	
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
