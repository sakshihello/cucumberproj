package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksTest {

	WebDriver driver;
	@Before
	public void launch_browser()
	{
		System.setProperty("webdriver.gecko.driver","C://Users//hp/geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver","C://Users//hp//Downloads//chromedriver-win32/chromedriver.exe");
	 	
	 	 driver = new FirefoxDriver();
	 
	}
 @After
	public void teardown()
	{
		driver.close();
		
	}
	
}

