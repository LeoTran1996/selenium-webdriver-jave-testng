package api;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Browser_Method {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01() {
		// Cac ham/ method/ command de tuong tac voi browser
		// Mo ra 1 ung dung web

		//driver.get("https://facebook.com");

		// Dong tab
	//	driver.close();

		// Dong trinh duyet
	//	driver.quit();

		// Kiem tra cai Url cua page mo ra co dung k
		//driver.getCurrentUrl();
	//	Assert.assertEquals(driver.getCurrentUrl(),
	//			"https://docs.google.com/document/d/1I39CE1Ae5VrMAGvbpM-9XmIJTpklP7jTrVw1ZxpXNOw/edit#heading=h.3mbwi9qo2jq9");

		// Lay ra title cua page hien tai
	//	driver.getTitle();
	//	Assert.assertEquals(driver.getTitle(), "My Acount");

		// Lay ra source code cua page hien tai
	//	driver.getPageSource();

		// Lay ra ID tab/windonws no dang dung
	//	driver.getWindowHandle();

		// Lay ra tat ca ID cua tat ca cac tab/windows
		//driver.getWindowHandles();
		
		// Back lai trang truoc
		//driver.navigate().back();
		
		// forward den trang tiep
	//	driver.navigate().forward();
		
		// refresh /f5 trang
	//	driver.navigate().refresh();
		
		//Mo ra 1 url tracking history tot hon
	//	driver.navigate().to("https://google.com.vn");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
