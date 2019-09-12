import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		Thread.sleep(4000);
		driver.close();
	}

	@Test
	public void departureCityCountTest() {
		// Get the total cities from departure and destination box.
		List<WebElement> CitySelBox = driver.findElements(By.cssSelector("form select"));
		
		//select the departure cities
		WebElement  depCityList = CitySelBox.get(0);
		//Get the list of departure cities
		List<WebElement> Listt = depCityList.findElements(By.cssSelector("option"));
		System.out.println("No. of Departure cities" +Listt.size());
		assertEquals(7,Listt.size());		
	}

}
