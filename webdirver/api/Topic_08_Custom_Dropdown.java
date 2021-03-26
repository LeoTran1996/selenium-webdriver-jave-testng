package api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void selectItemInCustomDropdown(String parentXpath, String allItemsXpath, String expectedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(1);

		// Cho cac item duoc hien thi ra truoc khi chon
		expilitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsXpath)));

		// Lay tat cac cac item luu vao 1 List de duyet qua
		List<WebElement> allItem = driver.findElements(By.xpath(allItemsXpath));

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
	
	
	public void TC4_React() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Christian");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Christian");
		
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Matt");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Matt");
		
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInCustomDropdown("//div[@role='listbox']", "//div[@role='option']/span", "Stevie Feliciano");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Stevie Feliciano");
	}

	
	public void TC_05_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "First Option");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "First Option");
		
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Second Option");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Second Option");
		
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Third Option");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Third Option");
	}
	
	@Test
	public void TC_06_Ediable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		selectItemInCustomDropdown("//input[@class='search']", "//div[@role='option']", "Belize");
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Belize");
		
		selectItemInEdiableBySendKeys("//input[@class='search']", "//div[@role='option']", "Armenia");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Armenia");
		sleepInSecond(1);
	}
	
	public void selectItemInEdiableBySendKeys(String parentXpath, String allItemsXpath, String expectedKeys) {
		
		driver.findElement(By.xpath(parentXpath)).clear();
		driver.findElement(By.xpath(parentXpath)).sendKeys(expectedKeys);
		sleepInSecond(1);
		List<WebElement> allItems = expilitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsXpath)));
		for (WebElement item : allItems) {
			if(item.getText().equals(expectedKeys)) {
				item.click();
				sleepInSecond(1);
				break;
			}
		}
		
		
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
