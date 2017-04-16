import java.sql.SQLException;
import java.util.*;

/**
 * Class that stores Profiles, pulls data and the like
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
        
        private ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	
	// Sets up all of the objects, to be executed in Main upon running the program
	public void setup(){
		meals.addAll(Arrays.asList(breakfast, lunch, dinner, other));
                for (Profile p : profiles) {
                    for (Meal meal : meals) {
                        p.addMeal(meal);
                    }
                }
                profiles.addAll(Arrays.asList(p1, p2, p3));
	}
        
        //copies profile q to profile w where q and w are the names of profiles
        public void copyProfile(String q, String w){
            Profile qq = getProfile(q);
            Profile ww = getProfile(w);
            ww = qq;
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
        
        
        

		
}