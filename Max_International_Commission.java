package Selenidedemo;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Max_International_Commission {

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
	public void commission() {
		driver.findElement(By.xpath("/html/body/div[18]//div[@class='col-md-3']/div[@class='row']/div[3]")).click();
	}
	
	@Test
	public void binaryTree() {
		JavascriptExecutor s = (JavascriptExecutor)driver;
    	s.executeScript("window.scrollBy(0,850)");
    	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@class = 'btn btn-primary vw_bn_btn']"))).click();
	   	}
	
	@AfterMethod
	public void realTimeCommission() {
		ArrayList<String> windowhandles = new ArrayList<String>(driver.getWindowHandles());
		String Parentwindow = windowhandles.get(0);
		driver.switchTo().window(Parentwindow);
		JavascriptExecutor s = (JavascriptExecutor)driver;
    	s.executeScript("window.scrollBy(0,250)");
	}
	
	@AfterTest
	public void plan() {
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[@class='section__mycomission']//a[@href='https://maxintlmarketing.s3-us-west-2.amazonaws.com/pdf/CompensationPlan/MaxCompPlan_Interactive_EN.pdf']//img[@alt='CompPlan']"))).click();
			}
	
	@AfterSuite
	public void aftersuite() {
		driver.close();
	}
}
