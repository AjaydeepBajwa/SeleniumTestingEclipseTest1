import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemoTest {
	//Location of Chromedriver file
	final String CHROMEDRIVER_LOCATION = "/Users/AJAY-MAC/chromedriver"; 
	
	// Website to be tested
	final String URL_TO_TEST = "http://www.blazedemo.com";
	
	//Global driver variables
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
	// Selenium setup
	System.setProperty("webdriver.chrome.driver",CHROMEDRIVER_LOCATION);
	driver = new ChromeDriver();
					
	//Go to Website
	driver.get(URL_TO_TEST);
		
	}

	@After
	public void tearDown() throws Exception {
		//After you run the test case, close the browser
		Thread.sleep(10000);
		driver.close();
	}

	@Test
	public void test() {
		
	}

}
