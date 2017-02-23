import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class FoodObjectTest {

	@Test
	public void checkCalTest() { //true if calories is nonnegative, false otherwise
		ArrayList<String> allerg = new ArrayList<String>();
		allerg.add("peanut");
		FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg);
		FoodObject food2 = new FoodObject("Impossible Fruit", "fruit", -125, new ArrayList<String>());

		assertTrue(food.checkCal(food.getCal()));
		assertFalse(food.checkCal(food2.getCal()));
	}
	
	@Test
	public void checkAlgTest() { //true if food contains any allergies (i.e. allergy arraylist is not empty), false otherwise 
		ArrayList<String> allerg = new ArrayList<String>();
		allerg.add("peanut");
		FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg);
		FoodObject food2 = new FoodObject("Apple", "fruit", 125, new ArrayList<String>());

		assertTrue(food.checkAlg());
		assertFalse(food2.checkAlg());
	}
	
	@Test
	public void adjustCalTest(){ //should triple and double the tested objects respectively
		ArrayList<String> allerg = new ArrayList<String>();
		allerg.add("peanut");
		FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg);
		FoodObject food2 = new FoodObject("Apple", "fruit", 125, new ArrayList<String>());
		food.adjustCal(3);
		food2.adjustCal(2);
		
		assertEquals(540, food.getCal());
		assertEquals(250, food2.getCal());
	}
	
}
