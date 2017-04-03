import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;import java.util.*;
import org.junit.Test;

/**
* Tester for Main
*/

public class MainTest {

	//Profile Test Objects
			Profile p1 = new Profile("P1");
			Profile p2 = new Profile("P2");
			Profile p3 = new Profile("P3");
	//Meal Test Objects
			ArrayList<FoodObject> foods = new ArrayList<FoodObject>();
			
			Meal b = new Meal("Breakfast");
			Meal l = new Meal("Lunch");
			Meal d = new Meal("Dinner");
			Meal o = new Meal("Other"); 
	//Food Test Object
			ArrayList<String> allerg = new ArrayList<String>();
			FoodObject food = new FoodObject("Peanut Butter", "snack", 180, allerg, 1);
	//Test String for Note
			String n = "this better work";
			


			
//	@Test
//	public void changeProfileTest() {
//	//Give all profiles meals
//		p1.addMeal(b); p1.addMeal(l); p1.addMeal(d); p1.addMeal(o);
//		p2.addMeal(b); p2.addMeal(l); p2.addMeal(d); p2.addMeal(o);
//		p3.addMeal(b); p3.addMeal(l); p3.addMeal(d); p3.addMeal(o);
//		
//		Main.changeProfile(p1,p2,p3);
//	}
//	
//	@Test
//	public void viewMealTest(){
//	// test Meal	
//		foods.add(food);
//		Meal lTest = new Meal(foods, "test note", 300, )
//				
//		Main.viewMeal(b);
//		
//	//tests positive assuming user-defined note = test string
//		assertEquals(b.getNotes(), n);
//		
//	//tests positive assuming user-defined Meal = test Meal
//	}
	
	@Test
	public void addFoodTest(){
		allerg.add("peanut");
		b.addFood(food);
		Main.addFood(o);
		
	//should test positive assuming user-defined food = food test object
		assertEquals(b.scanFood("Peanut Butter").toString(), o.scanFood("Peanut Butter").toString());
	}
		
}
