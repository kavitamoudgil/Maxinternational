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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Max_International_Myteam {
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
    
    @BeforeMethod
	public void myTeam() {
		
		driver.findElement(By.xpath("/html/body//div[@class='col-md-3']/div[@class='row']/div[4]/i[@class='material-icons']")).click();	
	}
	
	@Test
	public void entries() {
		
		WebElement element = driver.findElement(By.xpath("/html//select[@id='no_of_entry_container']"));
		element.click();
		Select s =new Select(element);
		s.selectByValue("100");
	}
	
	@AfterMethod
	public void downlineSearch() {
		driver.findElement(By.xpath("/html//input[@id='downline_search']")).sendKeys("products");
		JavascriptExecutor s = (JavascriptExecutor)driver;
		s.executeScript("window.scrollBy(0,850)");
		driver.findElement(By.xpath("//ul[@id='paginationContaner']/li[2]/a[@href='#']")).click();
	}
	
	
	@AfterSuite
	public void aftersuite() {
		driver.close();
	}
	
	
}