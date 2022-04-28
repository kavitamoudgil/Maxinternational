package Selenidedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Max_International_Snapshot{
	
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
	
	
	@BeforeTest
	public void snapShot() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class ='fa fa-user-circle']")).click();
		Thread.sleep(2000);
	}

	@BeforeClass
	public void overview() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id = 'nav-overview-tab']")).click();
		Thread.sleep(2000);
		JavascriptExecutor s = (JavascriptExecutor)driver;
    	s.executeScript("window.scrollBy(0,850)");
	}
	
	@Test
	public void commision() {
		driver.findElement(By.xpath("//a[@id='nav-commissions-tab']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-angle-right rank-arrow-font-size for-rank-name']"))).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='datePeriodCarousel']/div/a[1]/i[@class='fa fa-angle-left']"))).click();
		
		}
	
	@AfterClass
	public void Team() {
		driver.findElement(By.xpath("//a[@id ='nav-team-tab']")).click();
		JavascriptExecutor s = (JavascriptExecutor)driver;
    	s.executeScript("window.scrollBy(0,550)");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id ='snap_no_of_entry_container']")));
		WebElement element = driver.findElement(By.xpath("//select[@id ='snap_no_of_entry_container']"));		
		Select sl = new Select(element);
		sl.selectByValue("100");
	}
	
	@AfterTest
	public void Orders() {
		driver.findElement(By.xpath("//a[@id = 'nav-orders-tab']")).click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='order_table_filter']/descendant::input"))).sendKeys("API");		
		}
	
	@AfterSuite
	public void aftersuite() {
		driver.close();
	}
	
}
