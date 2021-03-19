package api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Method_part_2_exercise_optimization {
	WebDriver driver;
	By emailTextboxStatus = By.cssSelector("#mail");
	By ageUnderEighteenRadioStatus = By.id("under_18");
	By educationTextAreaStatus = By.cssSelector("#edu");
	By spliderTwoStatus = By.cssSelector("#slider-2");
	By slider1 = By.cssSelector("#slider-1");
	By slider2 = By.cssSelector("#slider-2");
	By javaCheckbox = By.cssSelector("#java");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test

	public void TC_01_isDisplayed() {

		driver.get("https://automationfc.github.io/basic-form/index.html");
		if (isElementDisplayed(emailTextboxStatus)) {
			sendkeyToElement(emailTextboxStatus, "Automation Testing");
		}
		if (isElementDisplayed(educationTextAreaStatus)) {
			sendkeyToElement(educationTextAreaStatus, "Automation Testing");
		}

		if (isElementDisplayed(ageUnderEighteenRadioStatus)) {
			clickToElement(ageUnderEighteenRadioStatus);

		}
	}

	@Test
	public void TC_02_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Assert.assertTrue(isElementEnabled(emailTextboxStatus));
		Assert.assertTrue(isElementEnabled(slider1));
		Assert.assertFalse(isElementEnabled(slider2));

	}

	@Test
	public void TC_03_isSelected() {

		driver.get("https://automationfc.github.io/basic-form/index.html");

		clickToElement(ageUnderEighteenRadioStatus);
		clickToElement(javaCheckbox);

		Assert.assertTrue(isElementSelected(ageUnderEighteenRadioStatus));
		Assert.assertTrue(isElementSelected(javaCheckbox));

		clickToElement(ageUnderEighteenRadioStatus);
		clickToElement(javaCheckbox);

		Assert.assertTrue(isElementSelected(ageUnderEighteenRadioStatus));
		Assert.assertFalse(isElementSelected(javaCheckbox));
	}

	public boolean isElementSelected(By by) {
		WebElement element = driver.findElement(by);
		if (element.isSelected()) {
			System.out.println("Element is selected");
			return true;
		} else {
			System.out.println("Element is not selected");
		}
		return false;

	}

	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			System.out.println("Element is Enabled");
			return true;
		} else {
			System.out.println("Element is Disable");
			return false;
		}

	}

	public boolean isElementDisplayed(By by) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed() == true) {
			System.out.println("Element is displayed");
			return true;
		} else {
			System.out.println("Element is not displayed");
			return false;
		}
	}

	public void sendkeyToElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}

	public void clickToElement(By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
