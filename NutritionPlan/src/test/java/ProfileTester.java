
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the Profile class, used to test various methods of the class.
 */
public class ProfileTester {
	
// Test Objects
	Profile tester = new Profile(); //Test Profile
	Meal testerMeal = new Meal(); //Test Meal
	
// Test Methods
	/**
	 * Creates a new Profile and tests to see if the meals begin empty.
	 */
	@Test
	public void testMealsAreEmpty(){
		assertTrue(tester.areMealsEmpty()); 
	}
	
	/**
	 * Creates a new Profile and tests to see if adding a meal adds
	 * to the size of the meals properly.
	 */
	@Test
	public void testMealsArentEmpty(){
		tester.addMeal(testerMeal);
		assertFalse(tester.areMealsEmpty());
	}

}
