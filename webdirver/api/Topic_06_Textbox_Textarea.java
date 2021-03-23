package api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_Textarea {

	WebDriver driver;
	String loginPageURL, userID, password;
	By customerNameTextbox = By.name("name");
	By genderRadioBy = By.name("gender");
	By dobTextbox = By.name("dob");
	By addressTextArea = By.name("addr");
	By cityTextbox = By.name("city");
	By stateTextbox = By.name("state");
	By pinTextbox = By.name("pinno");
	By mobileNumberTextbox = By.name("telephoneno");
	By emailTextbox = By.name("emailid");
	By passwordTextbox = By.name("password");
	String name, dob, addr, city, state, pinno, telephone, email, customerID;
	String editAddr, editCity, editState, editPinno, editTelephone, editEmail;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");

		name = "AnhTran";
		dob = "1996-03-03";
		addr = "47 Tran Van Du";
		city = "Winmagic";
		state = "Scotland";
		pinno = "030396";
		telephone = "01658780054";
		email = "boymaulanh03@gmail.com";

		editAddr = "968 duong 3 thang 2";
		editCity = "Quang Anh Viet Nam";
		editState = "Wales";
		editPinno = "140896";
		editTelephone = "01658780056";
		editEmail = "tranvananhqc1996@gmail.com";

	}

	@Test
	public void TC_01_Register() {
		loginPageURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("anhtranvan1996@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {

		driver.get(loginPageURL);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userID + "']")).isDisplayed());

	}

	@Test
	public void TC_03_New_Customer() {

		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(customerNameTextbox).sendKeys(name);
		driver.findElement(dobTextbox).sendKeys(dob);
		driver.findElement(addressTextArea).sendKeys(addr);
		driver.findElement(cityTextbox).sendKeys(city);
		driver.findElement(stateTextbox).sendKeys(state);
		driver.findElement(pinTextbox).sendKeys(pinno);
		driver.findElement(mobileNumberTextbox).sendKeys(telephone);
		driver.findElement(emailTextbox).sendKeys(email);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(By.name("sub")).click();
		
		
		// Kiem tra gia tri tra ve tu server

		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),addr);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinno);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),telephone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),email);

		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();

	}

	@Test
	public void TC_04_Edit_Customer() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

		// 3 fields disabled
		Assert.assertFalse(isElementEnabled(customerNameTextbox));
		Assert.assertFalse(isElementEnabled(genderRadioBy));
		Assert.assertFalse(isElementEnabled(dobTextbox));

		//
		Assert.assertEquals(driver.findElement(customerNameTextbox).getAttribute("value"), name);
		Assert.assertEquals(driver.findElement(genderRadioBy).getAttribute("value"), "male");
		Assert.assertEquals(driver.findElement(dobTextbox).getAttribute("value"), dob);
		Assert.assertEquals(driver.findElement(addressTextArea).getText(), addr);
		Assert.assertEquals(driver.findElement(cityTextbox).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(stateTextbox).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(pinTextbox).getAttribute("value"), pinno);
		Assert.assertEquals(driver.findElement(mobileNumberTextbox).getAttribute("value"), telephone);
		Assert.assertEquals(driver.findElement(emailTextbox).getAttribute("value"), email);

		// edit new data
		driver.findElement(addressTextArea).clear();
		driver.findElement(cityTextbox).clear();
		driver.findElement(stateTextbox).clear();
		driver.findElement(pinTextbox).clear();
		driver.findElement(mobileNumberTextbox).clear();
		driver.findElement(emailTextbox).clear();

		driver.findElement(addressTextArea).sendKeys(editAddr);
		driver.findElement(cityTextbox).sendKeys(editCity);
		driver.findElement(stateTextbox).sendKeys(editState);
		driver.findElement(pinTextbox).sendKeys(editPinno);
		driver.findElement(mobileNumberTextbox).sendKeys(editTelephone);
		driver.findElement(emailTextbox).sendKeys(editEmail);
		driver.findElement(By.name("sub")).click();

		driver.findElement(By.xpath("//p[text()='Customer details updated Successfully!!!']")).isDisplayed();

		// Kiem tra edit
	
		Assert.assertEquals(
				driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),
				dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),
				editAddr);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),
				editCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),
				editState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),
				editPinno);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),
				editTelephone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),
				editEmail);

	}

	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled() == true) {
			System.out.println("Element is enabled");
			return true;
		} else {
			System.out.println("Element is disabled");
			return false;
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
