package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_HTML {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		//Hiểu được HTML của 1 element
		//Thao tác với Đăng Kí Button
		
		//Tại sao phải bắt element
		//Bắt xong phải làm gì/thao tác như thế nào
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
