package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class TestCase2 extends TestBase{
	
	@Test(priority=1)
	public void testcase1() {
	 page.GetInstance1(LoginPage.class).navigateToApplication("https://google.com");
	}
	
	@Test(priority=2)
	public void testcase2() {
	 page.GetInstance1(LoginPage.class).navigateToApplication("https://google.com");
	}

}
