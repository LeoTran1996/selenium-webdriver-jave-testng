package api;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Window_Tab {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TestCase_01_Only_Two_Window_Or_Tab() {
		driver.get("https://kyna.vn/");
		
		String kynaParent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
		
		Switch_to_Window_ByID(kynaParent);
		sleepInTime(2);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
		
		//Switch lai parent (Kyan)
		
		String fbWindowID = driver.getWindowHandle();
		
		Switch_to_Window_ByID(fbWindowID);
		//sleepInTime(2);
		Assert.assertTrue(driver.getCurrentUrl().contains("kyna.vn"));

	}


	@Test
	public void TestCase_02_Greater_than_Two_Window_Or_Tab() {
		
	driver.get("https://kyna.vn/");
	
	String kynaIDParent = driver.getWindowHandle();
	//Click to Facebook	
	driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
	
	//Switch to Facebook	
	Switch_To_Window_Tab_By_Title("Kyna.vn | Trang Facebook đã xác minh");
	
	//Verify Facebook
	Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
	
	//Switch to Kyna
	Switch_To_Window_Tab_By_Title("Kyna.vn - Học online cùng chuyên gia");
	
	//Verify Kyna
	Assert.assertTrue(driver.getCurrentUrl().contains("kyna.vn"));
	//Click to Youtube
	driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt ='youtube']")).click();
	
	//Switch to Youtube	
	Switch_To_Window_Tab_By_Title("Kyna.vn - YouTube");
	
	//Verify Youtube
	Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
	
	//Switch to Kyna
	Switch_To_Window_Tab_By_Title("Kyna.vn - Học online cùng chuyên gia");
	
	//Verify Kyna
	Assert.assertTrue(driver.getCurrentUrl().contains("kyna.vn"));
	
	//Click to PRIMUS
	driver.findElement(By.xpath("//div[@id='k-footer']//a[text()='PRIMUS']")).click();
	
	//Switch to PRIMUS
	Switch_To_Window_Tab_By_Title("PRIMUS Homepage");
	
	//Verify PRIMUS
	Assert.assertTrue(driver.getCurrentUrl().contains("primus.vn"));
	
	//Switch to Kyna
	Switch_To_Window_Tab_By_Title("Kyna.vn - Học online cùng chuyên gia");
	
	//Verify Kyna
	Assert.assertTrue(driver.getCurrentUrl().contains("kyna.vn"));
	
	//Close all tab without Kyna parent
	Close_allTab_without_KynaParent(kynaIDParent);
	}
	
	public void Switch_To_Window_Tab_By_Title(String expectedWindowTitle) {
		Set<String> allIDs = driver.getWindowHandles();	
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualWindowTitle = driver.getTitle();
			if(actualWindowTitle.equals(expectedWindowTitle)) {
			break;	
			}
			
		}
	}

	public void sleepInTime(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Close_allTab_without_KynaParent(String WindowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if(!id.equals(WindowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}	
	}
	
	public void Switch_to_Window_ByID(String WindowID) {
		//Lay het tat ca ID cua window/tab hien co
		Set<String> allIDs = driver.getWindowHandles();
		
		//Dung vong lap duyet qua tung gia tri
		for (String id : allIDs) {
			
			//Moi lan duyet qua vong lap va so sanh gia tri
			//Neu khac voi ID parent thi switch vao
			if (!id.equals(WindowID)) {
				driver.switchTo().window(id);
				
				//Dat dieu kien va thoat khoi vong lap
				break;
			}
		}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
