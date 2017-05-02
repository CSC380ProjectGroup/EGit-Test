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
	
// True if calories is nonnegative, false otherwise
	@Test
	public void checkCalTest() { 
		allerg.add("peanut");
		assertTrue(food.checkCal(food.getCal()));
		assertFalse(food.checkCal(food3.getCal()));
		allerg.clear();
	}
	
// True if food contains any allergies (i.e. allergy arraylist is not empty), false otherwise
	@Test
	public void checkAlgTest() { 
		allerg.add("peanut");
		assertTrue(food.checkAlg());
		assertFalse(food2.checkAlg());
		allerg.clear();
	}
	
// Should triple and double the tested objects respectively
	@Test
	public void adjustCalTest() { 
		allerg.add("peanut");
		// food.adjustCal(3);
		// food2.adjustCal(2);
		food.setQuantity(3);
		food2.setQuantity(2); 
		assertEquals(540, food.getCal());
		assertEquals(250, food2.getCal());
		allerg.clear();
	}
	
// True if findAlg() finds a particular allergy, otherwise false	
	@Test
	public void findAlgTest() { 
		allerg.add("peanut");
		assertTrue(food.findAlg("peanut"));
		assertFalse(dFood.findAlg("peanut"));
	}
	
// Tests positive if addAlg() successfully adds the expected allergy string
	@Test
	public void addAlgTest() { 
		allerg.add("peanut");
		dFood.addAlg("peanut");
		assertEquals(dFood.printAlg(), food.printAlg());
		allerg.clear();
	}

	

}
