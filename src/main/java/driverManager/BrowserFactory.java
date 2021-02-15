package driverManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static final String USERNAME = "testgmailkhan1";
	public static final String AUTOMATE_KEY = "C4shbTCqwRpvE6aAdbxt";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public WebDriver createBrowserInstance(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--incognito");
          options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
          driver= new ChromeDriver(options);
          driver.manage().window().maximize();
			break;
		case "firefox":

			break;
		case "edge":

			break;
		case "opera":

			break;

		case "ie":

			break;

		case "safari":

			break;
		case "browserstack":
             try {
				driver = new RemoteWebDriver(new URL(URL), new ChromeOptions());
				((RemoteWebDriver)driver).setFileDetector(new LocalFileDetector());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "saucelabs":

			break;
		case "lambdatest":

			break;
		case "aws":

			break;
			
		case "ios":
			   try {
					IOSDriver<MobileElement> iosDriver = new IOSDriver<MobileElement>(new URL(""), new DesiredCapabilities());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case "Android":
			try {
				AndroidDriver<MobileElement> AndroidDriver = new AndroidDriver<MobileElement>(new URL(""), new DesiredCapabilities());
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
			break;


		default:
			break;
		}
		return driver;
	}

}
