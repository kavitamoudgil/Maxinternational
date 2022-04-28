package Selenidedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Max_International_login {

	public WebDriver driver;

	@BeforeSuite
	public void initianSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rikky\\OneDrive\\Desktop\\Software_Engineering\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("https://max.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id = 'myusername']")).sendKeys("11103");
		driver.findElement(By.xpath("//input[@id = 'mypassword']")).sendKeys("Cheese456!");
		driver.findElement(By.xpath("//button[@id = 'submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='agree_tc_user']"))).click();
		Thread.sleep(2000);
	}

		
	
    @AfterSuite
	public void aftersuite() {
		driver.close();
	}
}
