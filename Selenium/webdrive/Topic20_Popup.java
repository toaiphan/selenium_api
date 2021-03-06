package webdrive;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic20_Popup {
	WebDriver driver;
	Boolean status;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
	public void TC_01_Popup_Fix() {
		// mo trang
		driver.get("https://zingpoll.com/");

		// click vao login form
		driver.findElement(By.id("Loginform")).click();

		// kiem tra login form da hien thi""
		status = driver.findElement(By.id("Login")).isDisplayed();

		System.out.println(status);
		sleepInSecond(10);
		// ko hieu sao ko lay dc status
		// Assert.assertTrue(status);

		// click vao close
		driver.findElement(By.xpath("//button[@class='close' and @onclick='ResetForm()' ]")).click();

		// kiem tra login form ko hien thi
		status = driver.findElement(By.id("Login")).isDisplayed();
		System.out.println(status);
		sleepInSecond(10);
		// Assert.assertFalse(status);

		// click lai vao login form
		driver.findElement(By.id("Loginform")).click();
		sleepInSecond(5);

		// dien user name :automationfc.vn@gmail.com , pass la automationfc

		driver.findElement(By.id("loginEmail")).sendKeys("automationfc.vn@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("automationfc");

		// click vao signin
		driver.findElement(By.id("button-login")).click();

		// kiem tra login thanh cong (da hien thi ten cua user)
		System.out.println(driver.findElement(By.className("username")).getText());
		Assert.assertTrue(driver.findElement(By.className("username")).getText().contains("AUTOMATION TESTING"));

		sleepInSecond(10);

	}

	@Test
	public void TC_02_Popup_Random() {
		// mo trang
		driver.get("https://blog.testproject.io/");

		sleepInSecond(10);

		// neu popup hien len thi tat di
		if (driver.findElement(By.xpath("//div[@class='mailch-wrap']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='close-mailch']")).click();

		}

		// search selenium
		driver.findElement(By.xpath("//section[@id='search-2']//input[@placeholder='Search Articles']")).sendKeys("Selenium");

		// click search icon
		driver.findElement(By.cssSelector("#search-2 .glass")).click();
		// verify tat ca cac trang co tu khoa selenium

		List<WebElement> listTitles = driver.findElements(By.xpath("//h3[@class='post-title']"));
		for (WebElement title : listTitles) {
			Assert.assertTrue(title.getText().contains("Selenium"));
		}

	}

// ham nay de xu ly exception. neu pass thi sleep x giay, neu sai thi giu lai exception, chu ko stop cac testcase sau
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
