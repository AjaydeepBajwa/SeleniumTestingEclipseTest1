import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	Snake snake1;
	Snake snake2;
	
	@Before
	public void setUp() throws Exception {
		
		// Make a new snake objects that all test cases can use
		snake1 = new Snake("Peter",10,"coffee");
		snake2 = new Snake("Takis",80,"vegetables");
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isHealthyTest() {
		//check if snake1 is healthy
		assertTrue(snake1.isHealthy());
		
		//check if snake2 is healthy
		assertTrue(snake2.isHealthy());
		
		//check if snake1 is unhealthy
		assertFalse(snake1.isHealthy());
		
		//check if snake2 is unhealthy
		assertFalse(snake2.isHealthy());
	}
	
	@Test
	public void fitsInCageTest() {
		
		//check if snake1 fits in cage of length 9
		assertTrue(snake1.fitsInCage(9));
		
		//check if snake 1 fits in cage of length 10
		assertTrue(snake1.fitsInCage(10));
		
		//check snake1 fits in cage of length 11
		assertTrue(snake1.fitsInCage(11));
	}

	
}
