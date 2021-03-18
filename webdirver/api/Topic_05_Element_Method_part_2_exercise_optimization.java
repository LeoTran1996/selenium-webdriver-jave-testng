package api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Method_part_2_exercise_optimization {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test

	public void TC_01_isDisplayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		boolean emailTextboxStatus = driver.findElement(By.cssSelector("#mail")).isDisplayed();

		if (emailTextboxStatus == true) {
			driver.findElement(By.cssSelector("#mail")).sendKeys("Automation Testing");
			System.out.println("Email Textbox element is displayed");

		} else {
			System.out.println("Email Textbox element is not displayed");
		}

		boolean ageUnderEighteenRadioStatus = driver.findElement(By.xpath("//label[text()='Under 18']")).isDisplayed();

		if (ageUnderEighteenRadioStatus) {
			driver.findElement(By.id("under_18")).click();
			System.out.println("Under 18 Radion button element is displayed");
		} else {
			System.out.println("Under 18 Radion button is not displayed");
		}

		boolean educationTextAreaStatus = driver.findElement(By.cssSelector("#edu")).isDisplayed();

		if (educationTextAreaStatus) {
			driver.findElement(By.cssSelector("#edu")).sendKeys("Automation Testing");
			System.out.println("Education Textarea element is displayed");
		} else {
			System.out.println("Education Textarea is not displayed");
		}

	}

	@Test
	public void TC_02_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		boolean emailTextboxStatus = driver.findElement(By.cssSelector("#mail")).isEnabled();

		if (emailTextboxStatus) {
			System.out.println("Email Textbox is enabled");

		} else {
			System.out.println("Email Textbox is disabled");

		}
		boolean ageUnderEighteenRadioStatus = driver.findElement(By.id("under_18")).isEnabled();

		if (ageUnderEighteenRadioStatus) {
			System.out.println("ageUnderEighteenRadioStatus is enabled");

		} else {
			System.out.println("ageUnderEighteenRadioStatus is disabled");

		}

		boolean educationTextAreaStatus = driver.findElement(By.cssSelector("#edu")).isDisplayed();

		if (educationTextAreaStatus) {
			System.out.println("educationTextAreaStatus is enabled");

		} else {
			System.out.println("educationTextAreaStatus is disabled");

		}
		boolean spliderTwoStatus = driver.findElement(By.cssSelector("#slider-2")).isEnabled();

		if (spliderTwoStatus) {
			System.out.println("spliderTwoStatus is enabled");

		} else {
			System.out.println("spliderTwoStatus is disabled");

		}
		boolean spliderOneStatus = driver.findElement(By.cssSelector("#slider-1")).isEnabled();

		if (spliderOneStatus) {
			System.out.println("spliderOneStatus is enabled");

		} else {
			System.out.println("spliderOneStatus is disabled");

		}

	}

	@Test
	public void TC_03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		driver.findElement(By.id("under_18")).click();
		driver.findElement(By.cssSelector("#java")).click();

		Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());

		driver.findElement(By.id("under_18")).click();
		driver.findElement(By.cssSelector("#java")).click();

		Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("#java")).isSelected());

		boolean ageUnderEighteen = driver.findElement(By.id("under_18")).isSelected();
		boolean javaCheckbox = driver.findElement(By.cssSelector("#java")).isSelected();

		if (ageUnderEighteen) {
			System.out.println("ageUnderEighteen is selected");

		} else {
			System.out.println("ageUnderEighteen is unselected");

		}
		if (javaCheckbox) {
			System.out.println("javaCheckbox is selected");

		} else {
			System.out.println("javaCheckbox is unselected");

		}

	}

	// @Test
	public void TC_04_isDisplayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
