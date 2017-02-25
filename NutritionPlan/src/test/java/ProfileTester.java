
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the Profile class, used to test various methods of the class.
 */
public class ProfileTester {
	
	/**
	 * Creates a new Profile and tests to see if the meals begin empty.
	 */
	@Test
	public void testMealsAreEmpty(){
		Profile tester = new Profile();
		assertTrue(tester.areMealsEmpty()); 
	}
	
	/**
	 * Creates a new Profile and tests to see if adding a meal adds
	 * to the size of the meals properly.
	 */
	@Test
	public void testMealsArentEmpty(){
		Profile tester = new Profile();
		Meal testerMeal = new Meal();
		tester.addMeal(testerMeal);
		assertFalse(tester.areMealsEmpty());
	}

}
