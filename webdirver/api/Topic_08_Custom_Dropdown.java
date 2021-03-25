package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Topic_08_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait expilitwait;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\Browser\\chromedriver.exe" );
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		expilitwait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "18");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"18");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "5");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"5");

		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"19");

	}

	/*
	 * Hanh vi cua 1 Dropdown - Click vao dropdown - Cho cac item duoc hien thi ra -
	 * Tim cac item can chon +Item nao trong tam nhin thay cua user -> Click +Item
	 * nao khong nam trong tam nhin thay -> Scroll -> Click - Bam vao item can chon
	 * - Kiem tra xem chon dung chua
	 */
	public void selectItemInCustomDropdown(String parentXpath, String allIteamXpath, String expectedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(1);

		// Cho cac item duoc hien thi ra truoc khi chon
		expilitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allIteamXpath)));

		// Lay tat cac cac item luu vao 1 List de duyet qua
		List<WebElement> allItem = driver.findElements(By.xpath(allIteamXpath));

		// Dung vong lap duyet tung Item

		for (WebElement item : allItem) {
			// Duyet tung cai va get text ra
			// Neu nhu text bang cai mong doi thi click vao item do
			// Thoat khoi vong lap
			if (item.getText().equals(expectedText)) {
				item.click();
				sleepInSecond(1);
				break;
			}

		}
	}
	
	
	public void TC_02_Default_Dropdown() {


		driver.get("https://demo.nopcommerce.com/register");
		
		selectItemInCustomDropdown("//select[@name='DateOfBirthDay']", "//select[@name='DateOfBirthDay']/option", "15");
		selectItemInCustomDropdown("//select[@name='DateOfBirthMonth']", "//select[@name='DateOfBirthMonth']/option", "March");
		selectItemInCustomDropdown("//select[@name='DateOfBirthYear']", "//select[@name='DateOfBirthYear']/option", "1996");
		
	}
	
	@Test
	public void TC_03_Angular() {
		driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");
		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Basketball");
		sleepInSecond(1);
		Assert.assertEquals(getAngularDropdownSelectedItemText(), "Basketball");
		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Football");
		sleepInSecond(1);
		Assert.assertEquals(getAngularDropdownSelectedItemText(), "Football");
		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Tennis");
		sleepInSecond(1);
		Assert.assertEquals(getAngularDropdownSelectedItemText(), "Tennis");
		
	}
	
	public String getAngularDropdownSelectedItemText() {
		return (String) jsExecutor.executeScript("return document.querySelector(\"select[name='games']>option\").text");
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
