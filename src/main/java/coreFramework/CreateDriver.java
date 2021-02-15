package coreFramework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CreateDriver {
	private static CreateDriver instance = null;
	private  String browserHandle=null;
	private static final int IMPLICIT_TIMEOUT=10;
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();
	private ThreadLocal<String> sessionBrowser = new ThreadLocal<String>();
	private ThreadLocal<String> sessionPlatform = new ThreadLocal<String>();
	private ThreadLocal<String> sessionVersion = new ThreadLocal<String>();
	private String getEnv= null;
	
	private CreateDriver() {
		
	}
	public static CreateDriver getInstance() {
		if(instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}
	
	
	public void setDriver(String browser,String environment,String platform) throws MalformedURLException {
		DesiredCapabilities caps = null;
		switch (browser) {
		case "chrome":
			caps = DesiredCapabilities.chrome();
			webDriver.set(new ChromeDriver(caps));
			break;
		case "android":
		
			caps = DesiredCapabilities.android();
			mobileDriver.set(new AndroidDriver<MobileElement>(new URL(""),caps));
			break;

		default:
			break;
		}
	}
	
	
	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	
	public AppiumDriver<MobileElement> getDriver(boolean mobile) {
		return mobileDriver.get();
	}

}
