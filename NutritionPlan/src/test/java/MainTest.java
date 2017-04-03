import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;import java.util.*;
import org.junit.Test;

/**
* Tester for Main
*/

public class MainTest {

/**
 * Test Objects
 */
	//Meal Objects
			ArrayList<FoodObject> foods = new ArrayList<FoodObject>();
			Meal b = new Meal("Breakfast");
			Meal l = new Meal("Lunch");
			Meal d = new Meal("Dinner");
			Meal o = new Meal("Other"); 
	//FoodObject
			ArrayList<String> allerg = new ArrayList<String>();
			FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg, 1);
			
/**
 * Test Methods
 */
	// changeProfile and viewProfile don't need test methods, as they just
	// give access to the methods below and don't actually modify anything
			
	@Test
	public void viewMealTest(){
	// Test Meal	
		foods.add(food);
		Meal lTest = new Meal(foods, "test note", 180, "Breakfast");
		
		Main.viewMeal(b);  // Test method	

	// test is positive assuming user-defined Meal note = test Meal note
		assertEquals(b.getNotes(), lTest.getNotes());
	// test is positive assuming user-defined Meal info = test Meal info
		assertEquals(b.toString(), lTest.toString());
	}
	
	@Test
	public void addFoodTest(){
	//Test Food
		allerg.add("peanut");
		b.addFood(food);
		
		Main.addFood(o); // Test Method
		
	// test is positive assuming user-defined food = food test object
		assertEquals(b.scanFood("Peanut Butter").toString(), o.scanFood("Peanut Butter").toString());
	}
		
}
