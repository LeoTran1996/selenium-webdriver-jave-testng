package api;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Upload_File_Sendkey {
	WebDriver driver;
	String osName = System.getProperty("os.name");
	String projectPath = System.getProperty("user.dir");
	String seleniumFileName1 = "anhtran1.jpg";
	String seleniumFileName2 = "anhtran2.jpg";
	String seleniumFileName3 = "anhtran3.jpg";
	
	String seleniumPath1 = projectPath + getFileSeparator() + "Update_File" + getFileSeparator() + seleniumFileName1;
	String seleniumPath2 = projectPath + getFileSeparator() + "Update_File" + getFileSeparator() + seleniumFileName2;
	String seleniumPath3 = projectPath + getFileSeparator() + "Update_File" + getFileSeparator() + seleniumFileName3;
	
	@BeforeClass
	public void beforeClass() {
	}

	public void TC_01_Upload_One_File_Firefox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		//Load file len
		uploadFile.sendKeys(seleniumPath1);
		
		//Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName1 + "'] ")).isDisplayed());
		
		//Click Start to up load
		driver.findElement(By.cssSelector(".files .start")).click();
		
		//Verify  file uploaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName1 +"']")).isDisplayed());
		
		driver.quit();
		
	}
	public void TC_02_Upload_One_File_Chrome() {
		
		if(osName.contains("Window")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\Browser\\chromedriver.exe");
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath + "//Browser//chromedriver.exe");
		}
	
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		//Load file len
		uploadFile.sendKeys(seleniumPath1);
		
		//Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName1 + "'] ")).isDisplayed());
		
		//Click Start to up load
		driver.findElement(By.cssSelector(".files .start")).click();
		
		//Verify  file uploaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName1 +"']")).isDisplayed());
		
		driver.quit();
		
		
	}
	@Test
	public void TC_03_Upload_Multi_File() {
	 /*//Multi file khong uploaded tren firefox ban cu, phai xai firefox ban moi + selenium ban moi
	  *  Remove selenium ban cu -> add selenium ban moi -> add geckodriver
		//Firefox ban moi
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browser\\geckodriver.exe");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "//Browser//geckodriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		//Load file len
		uploadFile.sendKeys(seleniumPath1 + "/n" + seleniumPath2 + "/n" + seleniumPath3);
		
		//Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName3 + "'] ")).isDisplayed());
		
		//Click Start to up load
		driver.findElement(By.cssSelector(".files .start")).click();
		
		//Verify  file uploaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName1 +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName2 +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName3 +"']")).isDisplayed());
		
		driver.quit();
		*/
		
		//Chrome
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\Browser\\chromedriver.exe");
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath + "//Browser//chromedriver.exe");
		}
	
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		
		//Load file len
		uploadFile.sendKeys(seleniumPath1 + "\n" + seleniumPath2 + "\n" + seleniumPath3);
				
		//Verify file loaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + seleniumFileName3 + "'] ")).isDisplayed());
				
		//Click Start to up load
		List <WebElement> startButtons = driver.findElements(By.cssSelector(".files .start"));
		for (WebElement start : startButtons) {
			start.click();
			sleepInSecond(2);
		}
		
				
		//Verify  file uploaded successfully
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName1 +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName2 +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ seleniumFileName3 +"']")).isDisplayed());
				
		driver.quit();
		
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getFileSeparator() {
		return File.separator;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
