import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class MealTest {
    
    /**
     * Test of getTotalCalories method, of class Meal.
     */
    @Test
    public void testGetTotalCalories() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        int expResult = 180;
        int result = instance.getTotalCalories();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMealDate method, of class Meal.
     */
    @Test
    public void testGetMealDate() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        Date expResult = d;
        Date result = instance.getMealDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMealDate method, of class Meal.
     */
    @Test
    public void testSetMealDate() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Date date = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        instance.setMealDate(date);
        Date result = instance.getMealDate();
        assertEquals(date,result);
    }

    /**
     * Test of getNotes method, of class Meal.
     */
    @Test
    public void testGetNotes() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        String expResult = "apple and banana";
        String result = instance.getNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNotes method, of class Meal.
     */
    @Test
    public void testSetNotes() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        String expResult = "apple and banana";
        instance.setNotes("test");
        assertEquals("test", instance.getNotes());
    }

    /**
     * Test of addFood method, of class Meal.
     */
    @Test
    public void testAddFood() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        FoodObject pear = new FoodObject("pear","fruit",100,list);
        instance.addFood(pear);
        int expResult = 280;
        int result = instance.getTotalCalories();
        assertEquals(expResult,result);
    }

    /**
     * Test of removeFood method, of class Meal.
     */
    @Test
    public void testRemoveFood() {
        ArrayList<String> list = new ArrayList<String>();
        FoodObject apple = new FoodObject("apple","fruit",100,list);
        FoodObject banana = new FoodObject("banana","fruit",80,list);
        ArrayList<FoodObject> foodList = new ArrayList<FoodObject>();
        foodList.add(apple);
        foodList.add(banana);
        Date d = new Date();
        Meal instance = new Meal(foodList,"apple and banana",180,d,"Other");
        instance.removeFood(apple);
        int expResult = 80;
        int result = instance.getTotalCalories();
        assertEquals(expResult,result);
    }
    
}
