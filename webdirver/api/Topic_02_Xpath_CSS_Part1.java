package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_Part1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test
	public void TC_01_Validate() throws InterruptedException {
		//Hiểu được HTML của 1 element
		//Thao tác với Đăng Kí Button
	
		//Tại sao phải bắt element
		//Bắt xong phải làm gì/thao tác như thế nào
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Thread.sleep(5000);
		
		//Nhập vào textbox họ tên
		driver.findElement(By.cssSelector("input[id='txtFirstname']")).sendKeys("Automation FC");
		//Nhập vào textbox password
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		Thread.sleep(5000);
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}