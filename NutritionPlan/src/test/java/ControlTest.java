import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test certain methods used in Control
 */

public class ControlTest {
	
	Control c = new Control();

	// Test Lists
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();

	// Test Foods
	FoodObject apple = new FoodObject("apple", "fruit", 100, list, 1);
	FoodObject banana = new FoodObject("banana", "fruit", 80, list, 1);
	
// checks if copyProfile copies data properly
	@Test
	public void copyProfileTest() {
		c.getP1().getMeal("Other").addFood(apple);
		c.getP1().getMeal("Other").addFood(banana);
		c.copyProfile(1, 2);

		assertEquals(c.getP1().getMeal("Other").toString(), c.getP2().getMeal("Other").toString());
	}
	
// the created profile's output should be the equivalent of a newly created Profile object with the essential meals
	@Test
	public void createProfileTest() { 
		Profile pTest = new Profile("Test");
		Meal b = new Meal("Breakfast");
		Meal l = new Meal("Lunch");
		Meal d = new Meal("Dinner");
		Meal o = new Meal("Other");
		ArrayList<Meal> mealsT = new ArrayList<Meal>();
		mealsT.addAll(Arrays.asList(b, l, d, o));
		pTest.setListOfMeals(mealsT);
		String sTest = pTest.getListOfMeals().toString();

		c.createProfile(2, "Test");
		assertEquals(pTest.getName(), c.getP2().getName());
		assertEquals(sTest, c.getP2().getListOfMeals().toString());
	}
}
