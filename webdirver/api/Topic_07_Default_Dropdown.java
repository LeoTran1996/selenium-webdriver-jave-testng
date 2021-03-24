package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	By genderMaleRadio = By.cssSelector("#gender-male");
	By newLetterCheckbox = By.cssSelector("#Newsletter");
	Select select;
	String firstName, lastName, email, company, password;
	String day, month, year;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Anh";
		lastName = "Tran";
		company = "wimagic";
		password = "123456";

		day = "3";
		month = "March";
		year = "1996";

	}

	@Test
	public void TC_01_Register() {
		email = "anhtran" + getRandomNumber() + "@gmail.com";
		/* 1 - Mở trang Resgister */
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		/* 2 - Điền thông tin vào các fields required */

		checkToCheckboxOrRadio(genderMaleRadio);
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		// Khoi tao bien select thao tao voi Day Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(day);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);

		// Khoi tao bien select thao tao voi Month Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		List<WebElement> allItems = select.getOptions();
		Assert.assertEquals(allItems.size(), 13);

		for (WebElement item : allItems) {
			System.out.println(item.getText());
		}

		// Khoi tao bien select thao tao voi Year Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);

		// Kiem tra dropdown co phai multiple hay khong
		Assert.assertFalse(select.isMultiple());

		// Tra ve text da chon thanh cong
		// select.getFirstSelectedOption().getText();

		// Lay ra tat cac cac list items trong dropdown do
		// List <WebElement> allItems = select.getOptions();

		// Kiem tra xem so luong co bang mong muon hay khong
		// Assert.assertEquals(allItems.size(), 32);

		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Company")).sendKeys(company);
		checkToCheckboxOrRadio(newLetterCheckbox);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);

		/* 3 - Đăng kí */
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.id("register-button")).click();
		sleepInSecond(5);
		/* 4 - Kiểm tra xuất hiên message đăng kí thành công */
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText(),
				"Your registration completed");

		/* 5 - Vào trang my account */
		driver.findElement(By.cssSelector(".ico-account")).click();

		/* 6 - Kiểm tra đúng thông tin đã đăng kí */
		Assert.assertTrue(driver.findElement(By.cssSelector("#gender-male")).isSelected());
		Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.cssSelector("#LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.cssSelector("#Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.cssSelector("#Company")).getAttribute("value"), company);
		Assert.assertTrue(driver.findElement(By.cssSelector("#Newsletter")).isSelected());

		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);

	}

	@Test

	public void TC_02_Multiple_Select() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		select = new Select(driver.findElement(By.xpath("//select[@id='job2']")));

		ArrayList<String> allItemsText = new ArrayList<String>();

		allItemsText.add("Automation");
		allItemsText.add("Manual");
		allItemsText.add("Mobile");
		allItemsText.add("Security");

		// Chon 4 items
		for (String item : allItemsText) {
			select.selectByVisibleText(item);
		}

		// Kiem tra co ho tro multiple hay khong
		Assert.assertTrue(select.isMultiple());

		// Kiem tra da chon dung 4 items thanh cong
		List<WebElement> allISelectedItems = select.getAllSelectedOptions();
		ArrayList<String> allLSelectedText = new ArrayList<String>();

		for (WebElement item : allISelectedItems) {
			allLSelectedText.add(item.getText());

		}

		Assert.assertEquals(allLSelectedText.size(), 4);
		Assert.assertEquals(allItemsText, allLSelectedText);

	}

	public void checkToCheckboxOrRadio(By by) {
		WebElement element = driver.findElement(by);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
