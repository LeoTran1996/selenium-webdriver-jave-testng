package api;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_17_Webdriver_Wait_PartVII_FluentWait {
	WebDriver driver;
	WebElement element;
	FluentWait<WebDriver> fluentDriver;
	String projectFolder = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\Browser\\chromedriver.exe" );
		
		driver = new ChromeDriver();
	}

	public void TC_01_Wait_And_Click_To_Element() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		WaitandClickToElement(By.xpath("//div[@id='start']/button"));
		
		WaitandVerifyText(By.xpath("//div[@id='finish']/h4"), "Hello World!");
	}

	@Test
	public void TC_02_Wait_And_GetTextEndWith() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		
		WaitandVerifyTextEndWith(By.xpath("//div[@id='javascript_countdown_time']"), "00");

	}
	
	public void WaitandClickToElement(By xpath) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		//Tong thoi gian de cho
		fluentDriver.withTimeout(15,TimeUnit.SECONDS)
		//Tan so moi 1s check 1 lan
		.pollingEvery(1, TimeUnit.SECONDS)
		//Neu gap exception la find khong thay elementse bo qua
		.ignoring(NoSuchElementException.class);
		
		WebElement element =(WebElement) fluentDriver.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(xpath);
			}
		});
		element.click();
	}
	public void WaitandVerifyText(By xpath, String expectedText) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		//Tong thoi gian de cho
		fluentDriver.withTimeout(15,TimeUnit.SECONDS)
		//Tan so moi 1s check 1 lan
		.pollingEvery(1, TimeUnit.SECONDS)
		//Neu gap exception la find khong thay elementse bo qua
		.ignoring(NoSuchElementException.class);
		
		fluentDriver.until(new Function<WebDriver, Boolean >() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(xpath).getText().equals(expectedText);
			}
		});
	}
	public void WaitandVerifyTextEndWith(By xpath, String expectedText) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		//Tong thoi gian de cho
		fluentDriver.withTimeout(15,TimeUnit.SECONDS)
			//Tan so moi 1s check 1 lan
			.pollingEvery(500, TimeUnit.MILLISECONDS)
			//Neu gap exception la find khong thay elementse bo qua
			.ignoring(NoSuchElementException.class);
		
		fluentDriver.until(new Function<WebDriver, Boolean >() {
			public Boolean apply(WebDriver driver) {
				String actualText = driver.findElement(xpath).getText();
				System.out.println("Text= " + actualText);
				return actualText.endsWith(expectedText);
			}
		});
	
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}