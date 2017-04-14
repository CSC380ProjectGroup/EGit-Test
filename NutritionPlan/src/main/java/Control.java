import java.util.*;

/**
 * Class that stores Profiles, pulls daa and the like
 */
public class Control {
	
	private Meal breakfast = new Meal("Breakfast"); 
	private Meal lunch = new Meal("Lunch"); 
	private Meal dinner = new Meal("Dinner");
	private Meal other = new Meal("Other"); 
	
	private ArrayList<Meal> meals = new ArrayList<Meal>();

	private Profile p1 = new Profile("Profile 1");
	private Profile p2 = new Profile("Profile 2");
	private Profile p3 = new Profile("Profile 3");
	
	
	// Sets up all of the objects, to be executed in Main upon running the program
	public void setup(){
		meals.addAll(Arrays.asList(breakfast, lunch, dinner, other));
	}
	
	
	
}