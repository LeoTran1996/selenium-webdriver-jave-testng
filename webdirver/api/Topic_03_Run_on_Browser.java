package api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_Run_on_Browser {
	String projectlocation = System.getProperty("user.dir");

	WebDriver driver;

	@Test
	public void TC1_Run_On_FireFox() {
		// Firefox 47 + Selenium 2.xx + khong dung Geckodriver
		driver = new FirefoxDriver();

		// Firefox 48 + Selenium 3.xx + Geckodriver
		// System.setProperty("webdriver.gecko.driver", "//path_of_Gecko_driver");

		driver.get("https://google.com");

		driver.quit();

	}

	@Test
	public void TC2_Run_On_Chrome() {
		// 01

		System.setProperty("webdriver.chrome.driver","D:\\AutomationTesting\\02-Selenium API-Company PC\\selenium-webdriver-jave-testng\\Browser\\chromedriver.exe");
		// 02

		System.setProperty("webdriver.chrome.driver", ".\\Browser\\chromedriver.exe");

		// 03
		System.setProperty("webdriver.chrome.driver", projectlocation + "\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.quit();

	}

}
