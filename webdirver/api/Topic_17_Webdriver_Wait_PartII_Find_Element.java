package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Webdriver_Wait_PartII_Find_Element {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		
		// implicitlyWait là khoảng thời gian chờ cho việc tìm Element
		// Wait ngầm định: cho việc tìm Element
		// Tìm Element: findElement, findElements
		
	}


	public void TC_01_Find_Elemement() {
		// Single
		// Khi đi tìm Element:
		// Trường hợp 1 khi có duy nhât 1 matching node:
		// 1.1: Element xuất hiện ngay -> không cần chờ hết timeout
		// 1.2: khi bắt đầu tìm kiếm, Element chưa xuất hiện -> tìm lặp lại Element cứ mỗi 0.5 giây
		//  - nếu như tìm thấy -> chuyển qa step tiếp mà k cần chờ hết timeout
		// 	- nếu không tìm thấy:
		//		+ Throw ra Exception NoSuchElement
		// 		+ Đánh failed testcase và không chạy các step tiếp theo.
		
		// Trưởng hợp 2 không có matching node nào
		// Tìm Element với polling là 0.5s -> chờ cho hết timeout
		// Nếu không tìm thấy sau khi hết timeout
		// +Throw ra 1 Exception NoSuchElement
		// +Đánh failed testcase, không chạy các step tiếp theo
		// Trường hợp 3 nhiều hơn 1 matching node
		// Nếu như tìm thấy nhiều hơn 1 thì luôn thao tác với Element đầu tiên
		
		
	}

	public void TC_02_Find_Elements() {
		// Trường hợp 1: Có duy nhất 1 matching node
		// Không cần chờ hết timeout -> trả về 1 list chứa element đó
		// Trường hợp 2: không có matching node nào
		// Tìm lặp lại cho đến hết timeout 
		// Hết timeout mà không tìm thấy thì không đánh failed testcase
		// + Trả về list rỗng
		// + Chuyển qua step khác
		
		// Trường hợp 3: Nhiều hơn 1 maching node
		// Không cần chờ hết timeout
		// Trả về list chứa elements đó
		
		
	
	}

	@Test
	public void TC_03_Less_Than() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed());
		
		
		
		
	}
	@Test
	public void TC_04_Greater_Than_Or_Equal() {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed());
		
	}
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
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
