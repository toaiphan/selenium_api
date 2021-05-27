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

public class Topic23_Upload_Files {
	WebDriver driver;
	
	//tao ra duong dan tuong doi, de van chay dc trên máy khác
	String source_folder = System.getProperty("user.dir");
	String image_name_01 ="hanoi";
	String image_name_02 ="hue";
	String image_name_03 ="saigon";

	String image_01_path = source_folder +"\\uploadFiles\\"+image_name_01;
	String image_02_path = source_folder +"\\uploadFiles\\"+image_name_02;
	String image_03_path = source_folder +"\\uploadFiles\\"+image_name_03;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_sendkeys() {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys(image_01_path);
		sleepInSecond(1);
		uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys(image_02_path);
		sleepInSecond(1);
		uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys(image_03_path);
		sleepInSecond(10);
	}
	@Test
	public void TC_02_() {
		driver.get("");

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