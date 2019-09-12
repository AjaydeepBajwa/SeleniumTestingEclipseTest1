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
		List<WebElement> totalCitiesSel = driver.findElements(By.cssSelector("form select"));
		
		//select the departure cities
		WebElement  depCitySel = totalCitiesSel.get(0);
		//Get the list of departure cities
		List<WebElement>  depCityList= depCitySel.findElements(By.cssSelector("option"));
		System.out.println("No. of Departure cities :" +depCityList.size());
		assertEquals(7,depCityList.size());		
	}
	
	@Test
	public void virginAmericaflightTest() {
		//get find flights button
		WebElement findFlightBtn = driver.findElement(By.cssSelector(".container .container input"));
		
		//click the button
		findFlightBtn.click();
		
		//get all the flights available
		List<WebElement> allFlights = driver.findElements(By.cssSelector("table tbody tr"));
		System.out.println("No. of flights " +allFlights.size());
		
		//get Virgin America Flight #12
		WebElement Flight12 = allFlights.get(3);
		//get details of flight#12
		List<WebElement> flightDetails = Flight12.findElements(By.cssSelector("td"));
		System.out.println("No. of columns " +flightDetails.size());
		
		System.out.println("Departs at : " +flightDetails.get(3).getText());
		//checking if the departure time is 11:23 AM
		assertEquals("11:23 AM",flightDetails.get(3).getText());
		
		//checking if the arrival time is 1:45 AM
		assertEquals("1:45 PM",flightDetails.get(4).getText());
		System.out.println("Departs at : " +flightDetails.get(4).getText());
				
		//checking if the cost is $765.32
		assertEquals("$765.32",flightDetails.get(5).getText());
		System.out.println("Departs at : " +flightDetails.get(5).getText());
		
		// get the 'choose this flight' button and click it
		WebElement selFlightBtn =  flightDetails.get(0);
		selFlightBtn.click();
	}
	
	@Test
	public void purchaseConfirmationTest() {
		
		virginAmericaflightTest();
		//select the purchase flight button
		
		WebElement purBtn = driver.findElement(By.cssSelector(".container form .controls input"));
		purBtn.click();
		System.out.println(purBtn.getText());
	}

}
