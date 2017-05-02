import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class MealTest {
		
// Test Lists
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
    
// Test Foods
	FoodObject apple = new FoodObject("apple", "fruit", 100, list, 1);
	FoodObject banana = new FoodObject("banana", "fruit", 80, list, 1);
	
// Test Meal
	Meal instance = new Meal(foodList, "apple and banana", 180, "Other");
	
/**
 * Test of getTotalCalories method, of class Meal.
 */
    @Test
    public void testGetTotalCalories() {
        foodList.add(apple);
        foodList.add(banana);
        int expResult = 180;
        int result = instance.getTotalCalories();
        assertEquals(expResult, result);
        foodList.clear();
    }

/**
 * Test of getNotes method, of class Meal.
 */
    @Test
    public void testGetNotes() {
        foodList.add(apple);
        foodList.add(banana);
        String expResult = "apple and banana";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        foodList.clear();
    }

/**
 * Test of setNotes method, of class Meal.
 */
    @Test
    public void testSetNotes() {
        foodList.add(apple);
        foodList.add(banana);
        instance.setNotes("test");
        assertEquals("test", instance.getNotes());
    }

/**
 * Test of addFood method, of class Meal.
 */
    @Test
    public void testAddFood() {
        foodList.add(apple);
        foodList.add(banana);
        FoodObject pear = new FoodObject("pear","fruit",100,list,1);
        instance.addFood(pear);
        int expResult = 280;
        int result = instance.getTotalCalories();
        assertEquals(expResult,result);
        foodList.clear();
    }

/**
 * Test of removeFood method, of class Meal.
 */
    @Test
    public void testRemoveFood() {
        foodList.add(apple);
        foodList.add(banana);
        instance.removeFood(apple);
        int expResult = 80;
        int result = instance.getTotalCalories();
        assertEquals(expResult,result);
        
    }
    
/**
 * Test of giveFood method, of class Meal.
 */
    @Test
    public void testGiveFood() {
        foodList.add(apple);
        foodList.add(banana);
        assertEquals("apple\nbanana\n", instance.giveFood());
        foodList.clear();
    }
    
/**
 * Test of scanFood method, of class Meal.
 */
    @Test
    public void testScanFood() {
    	foodList.add(apple);
    	assertEquals(null, instance.scanFood("banana"));
    	assertEquals(apple, instance.scanFood("apple"));
    	foodList.add(banana);
    	assertEquals(banana, instance.scanFood("banana"));
    	foodList.clear();
    }
    
    @Test
    public void testGetAllAlg() {
        ArrayList<String> allerg1 = new ArrayList<String>();
        ArrayList<String> allerg2 = new ArrayList<String>();

    	Meal m = new Meal();

    	allerg1.add("peanut");
    	FoodObject pb = new FoodObject("Peanut Butter", "snack", 180, allerg1, 1); 
    	m.addFood(pb);

    	allerg2.add("milk");
    	FoodObject cheese = new FoodObject("Cheese", "snack", 50, allerg2, 1);
    	m.addFood(cheese);
    	
    	Meal empty = new Meal();
    	
    	assertEquals("peanut\nmilk\n", m.getAllAlg());
    	assertEquals("None.", empty.getAllAlg());
    	allerg1.clear();
    	allerg2.clear();
    }
    
}
