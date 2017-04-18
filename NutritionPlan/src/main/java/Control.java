import java.sql.SQLException;
import java.util.*;

/**
 * Class that stores Profiles and Meal objects, pulls data, and the like
 */
public class Control {
	
	private Meal b1 = new Meal("Breakfast"); 
	private Meal l1 = new Meal("Lunch"); 
	private Meal d1 = new Meal("Dinner");
	private Meal o1 = new Meal("Other"); 
	
	private Meal b2 = new Meal("Breakfast"); 
	private Meal l2 = new Meal("Lunch"); 
	private Meal d2 = new Meal("Dinner");
	private Meal o2 = new Meal("Other"); 
	
	private Meal b3 = new Meal("Breakfast"); 
	private Meal l3 = new Meal("Lunch"); 
	private Meal d3 = new Meal("Dinner");
	private Meal o3 = new Meal("Other"); 
	
	private ArrayList<Meal> meals = new ArrayList<Meal>();

	private Profile p1 = new Profile("Profile 1");
	private Profile p2 = new Profile("Profile 2");
	private Profile p3 = new Profile("Profile 3");
        
    private ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	
	// Sets up all of the objects, to be executed in Main upon running the program
//TODO: Fix this method
	public void setup(){
		meals.addAll(Arrays.asList(breakfast, lunch, dinner, other));
                for (Profile p : profiles) {
                    for (Meal meal : meals) {
                        p.addMeal(meal);
                    }
                }
                profiles.addAll(Arrays.asList(p1, p2, p3));
	}
        
    // Copies profile q's information to Profile w, using copy constructors
    public void copyProfile(Profile q, Profile w){
        Profile temp = new Profile(q);
        w = temp;
    }
    
    public Profile getProfile(String profileName){
        Profile pr = null;
        for (Profile p: profiles) {
            if (p.getName().equals(profileName)) {
                pr = p;
            }
        }
        return pr;
    }
    
    public Meal getMeal(Profile p, String mealName){
        return p.getMeal(mealName);
    }
    
    public void createProfile(String profileName){
        Profile p = new Profile(profileName);
    }
    
    public Meal createMeal(String type){
        Meal m = new Meal();
        m.setType(type);
        return m;
    }
    
    public void addFoodToMeal(Meal m, String foodName) throws ClassNotFoundException, SQLException{
        FoodObject f = DBStuff.getFoodDB(foodName);
        m.addFood(f);
    }
    
    public void addMeal(Profile p, String type){
        Meal m = createMeal(type);
        p.addMeal(m);
    }
        
    public int getMealCal(Meal m){
    	return m.getTotalCalories();
    }
    
	public String getMealAlg(Meal m){
    	return m.getAllAlg();
    }
	
	public String getMealFood(Meal m){
		return m.giveFood();
	}

	public String getMealNotes(Meal m){
		return m.getNotes();
	}
	
	public void setMealNotes(Meal m, String n){
		m.setNotes(n);
	}
	
	
}