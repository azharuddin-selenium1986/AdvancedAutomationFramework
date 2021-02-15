package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import core.Page;
import driverManager.BrowserFactory;
import driverManager.DriverFactory;


public class TestBase {
	WebDriver driver =null;
	BrowserFactory browserFactory = new BrowserFactory();
	public Page page;
	public WebDriverWait wait;
	public ExtentTest test;
	@BeforeTest
	public void setUp() {
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance("browserstack"));
	    driver = DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page = new Page(driver, wait, test);
	}
	
	
	@AfterTest
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser(); 
	}
}
