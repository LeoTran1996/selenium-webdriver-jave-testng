package api;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.javafx.scene.text.HitInfo;
import com.sun.xml.internal.ws.api.pipe.NextAction;

public class Topic_15_JavaScipt_Executor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TestCase_01() {
		navigateToUrlByJS(driver, "http://live.demoguru99.com/");
		
		String hompageDomain = (String) executeForBrowser(driver, "return document.domain;");
		
		Assert.assertEquals(hompageDomain, "live.demoguru99.com");
		
		String hompageUrl = (String) executeForBrowser(driver, "return document.URL;");
		
		Assert.assertEquals(hompageUrl, "http://live.demoguru99.com/");
		
		highlightElement(driver, "//a[text()='Mobile']");
		clickToElementByJS(driver, "//a[text()='Mobile']");
		
		highlightElement(driver, "//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		clickToElementByJS(driver, "//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		
		highlightElement(driver, "//li[@class='success-msg']//span");
		Assert.assertTrue(getInnerText(driver).contains("Samsung Galaxy was added to your shopping cart."));
		
		highlightElement(driver, "//a[text()='Customer Service']");
		clickToElementByJS(driver, "//a[text()='Customer Service']");
		
		highlightElement(driver, "//input[@id='newsletter']");
		scrollToElement(driver, "//input[@id='newsletter']");
		sendkeyToElementByJS(driver, "//input[@id='newsletter']", getRandomEmail());
		
		highlightElement(driver, "//button[@title='Subscribe']");
		clickToElementByJS(driver, "//button[@title='Subscribe']");
		
		highlightElement(driver, "//li[@class='success-msg']//span");
		Assert.assertTrue(getInnerText(driver).contains("Thank you for your subscription."));
		
		navigateToUrlByJS(driver, "http://demo.guru99.com/v4/");
		String homepageDomain2 = (String) executeForBrowser(driver, "return document.domain;");
		Assert.assertEquals(homepageDomain2, "demo.guru99.com");
			
	}

	public void TestCase_02() {
		
		navigateToUrlByJS(driver, "https://login.ubuntu.com/");
		sleepInSecond(5);
		
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='email']"), "Please fill out this field.");
		
		sendkeyToElementByJS(driver, "//input[@name='email']", "aa");
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='email']"), "Please include an '@' in the email address. 'aa' is missing an '@'.");
		
		sendkeyToElementByJS(driver, "//input[@name='email']", "aa@");
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='email']"), "Please enter a part following '@'. 'aa@' is incomplete.");
		
		sendkeyToElementByJS(driver, "//input[@name='email']", "123@...");
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='email']"), "'.' is used at a wrong position in '...'.");
		
		sendkeyToElementByJS(driver, "//input[@name='email']", "anhtran@gmail.com");
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='password']"), "Please fill out this field.");
		
		sendkeyToElementByJS(driver, "//input[@name='email']", "anhtran@gmail.com");
		clickToElementByJS(driver, "//button[@data-qa-id='login_button']");
		sleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(driver, "//input[@name='password']"), "Please fill out this field.");
		
	}
	
	@Test
	public void TestCase_03() {
		String loginPageURL, userID, password;
		String name, dob, addr, city, state, pinno, telephone, email, customerID;
		String editAddr, editCity, editState, editPinno, editTelephone, editEmail;
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
		
		name = "AnhTran";
		dob = "1996-03-03";
		addr = "47 Tran Van Du";
		city = "Winmagic";
		state = "Scotland";
		pinno = "030396";
		telephone = "01658780054";
		
		driver.get("http://demo.guru99.com/v4/");
		
		loginPageURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("anhtranvan1996@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();


		driver.get(loginPageURL);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userID + "']")).isDisplayed());
	
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(customerNameTextbox).sendKeys(name);
		//remove attribute type = date
		removeAttributeInDOM(driver, "//input[@name='dob']", "type");
		sleepInSecond(3);
		driver.findElement(dobTextbox).sendKeys(dob);
		
		driver.findElement(addressTextArea).sendKeys(addr);
		driver.findElement(cityTextbox).sendKeys(city);
		driver.findElement(stateTextbox).sendKeys(state);
		driver.findElement(pinTextbox).sendKeys(pinno);
		driver.findElement(mobileNumberTextbox).sendKeys(telephone);
		driver.findElement(emailTextbox).sendKeys(getRandomEmail());
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

	}
	
	
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "anhtran" + rand.nextInt() + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
