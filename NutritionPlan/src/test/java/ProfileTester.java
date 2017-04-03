
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
	 *  Tests to see if the meals begin empty.
	 */
	@Test
	public void testMealsAreEmpty(){
		assertTrue(tester.areMealsEmpty()); 
	}
	
	/**
	 * Tests to see if adding a meal adds to the size of the meals properly.
	 */
	@Test
	public void testMealsArentEmpty(){
		tester.addMeal(testerMeal);
		assertFalse(tester.areMealsEmpty());
		tester.getListOfMeals().clear();
	}
	
	/**
	 * Tests to see if getMeal() finds the expected Meal object
	 */
	@Test
	public void testGetMeal() {
		tester.addMeal(testerMeal);
		assertEquals(tester.getMeal(""), testerMeal);
	}

}
