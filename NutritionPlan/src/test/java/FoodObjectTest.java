import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

/**
* Tester for FoodObject methods
* @author Brandon
*/

public class FoodObjectTest {
	
	ArrayList<String> allerg = new ArrayList<String>();
	FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg, 1);
	FoodObject food2 = new FoodObject("Apple", "fruit", 125, new ArrayList<String>(), 1);
	FoodObject food3 = new FoodObject("Impossible Fruit", "fruit", -125, new ArrayList<String>(), 1);
	FoodObject dFood = new FoodObject(); // FoodObject with default values
	
	@Test
	public void checkCalTest() { //true if calories is nonnegative, false otherwise
		allerg.add("peanut");
		assertTrue(food.checkCal(food.getCal()));
		assertFalse(food.checkCal(food3.getCal()));
		allerg.clear();
	}
	
	@Test
	public void checkAlgTest() { // true if food contains any allergies (i.e.
									// allergy arraylist is not empty), false
									// otherwise
		allerg.add("peanut");
		assertTrue(food.checkAlg());
		assertFalse(food2.checkAlg());
		allerg.clear();
	}
	
	@Test
	public void adjustCalTest() { // should triple and double the tested objects
									// respectively
		allerg.add("peanut");
		// food.adjustCal(3);
		// food2.adjustCal(2);
		food.setQuantity(3); // setQuantity() runs the adjustCal() method
		food2.setQuantity(2); // (setting quantity and running adjustCal() do
								// essentially the same thing)

		assertEquals(540, food.getCal());
		assertEquals(250, food2.getCal());
		allerg.clear();
	}
	
	@Test
	public void findAlgTest() { // true if findAlg() finds a particular allergy,
								// otherwise false
		allerg.add("peanut");

		assertTrue(food.findAlg("peanut"));
		assertFalse(dFood.findAlg("peanut"));
	}
	
	@Test
	public void addAlgTest() { // tests positive if addAlg() successfully adds
								// the expected allergy string
		allerg.add("peanut");
		dFood.addAlg("peanut");

		assertEquals(dFood.printAlg(), food.printAlg());
		allerg.clear();
	}

	

}
