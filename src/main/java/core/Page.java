package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Page {
	  public WebDriver driver;
	    public WebDriverWait wait;
	    public ExtentTest test;
	    //Constructor
	    public Page(WebDriver driver, WebDriverWait wait,ExtentTest test){
	        this.driver = driver;
	        this.wait = wait;
	        this.test = test;
	        PageFactory.initElements(driver, this);
	    }
	 
	    //JAVA Generics to Create and return a New Page
	    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
	        try {
	            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    //JAVA Generics to Create and return a New Page
	    public  <TPage extends BasePage> TPage GetInstance1 (Class<TPage> pageClass) {
	        try {
	            return pageClass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class,ExtentTest.class).newInstance(this.driver,this.wait,this.test);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
