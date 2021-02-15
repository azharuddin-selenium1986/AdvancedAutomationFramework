package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import extentreport.ExtentLogger;
//import utility.UiAction;

public class BasePage extends Page {
	
	//protected UiAction uiAction;
	//protected ExtentLogger extentLogger;
	 public BasePage(WebDriver driver, WebDriverWait wait,ExtentTest test) {
	        super(driver, wait,test);
	       // uiAction = new UiAction(driver);
	        //extentLogger=new ExtentLogger(test);
	    }
	
	 
		public void navigateToApplication(String url){
			driver.get(url);
			//extentLogger.addInfo("Open Application URL :"+ url);
		}
		
		public String addScreenshot() {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String encodedBase64 = null;
			FileInputStream fileInputStreamReader = null;
			try {
				fileInputStreamReader = new FileInputStream(scrFile);
				byte[] bytes = new byte[(int) scrFile.length()];
				fileInputStreamReader.read(bytes);
				encodedBase64 = new String(Base64.encodeBase64(bytes));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				test.log(LogStatus.FAIL, e.getMessage());
				//extentLogger.addInfo(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				//extentLogger.addInfo(e.getMessage());
			}
			return "data:image/png;base64," + encodedBase64;
		}
		

}
