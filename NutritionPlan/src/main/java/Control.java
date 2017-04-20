import java.sql.SQLException;
import java.util.*;

/**
 * Class that stores Profiles objects, pulls data, and the like
 */
public class Control {

// Meal ArrayLists for each Profile
	private ArrayList<Meal> meals1;
	private ArrayList<Meal> meals2;
	private ArrayList<Meal> meals3;

// Profile Objects
	private Profile p1;
	private Profile p2;
	private Profile p3;
        	
// Default Constructor
    public Control() {
    	meals1 = new ArrayList<Meal>();
    	meals2 = new ArrayList<Meal>();
    	meals3 = new ArrayList<Meal>();
    	
    	p1 = new Profile("Profile 1");
    	p2 = new Profile("Profile 2");
    	p3 = new Profile("Profile 3");
    	
    	setup();
    }
	
// Sets up Profile objects to include their own empty Meal objects on launch
	public void setup() {
		Meal b1 = new Meal("Breakfast");
		Meal l1 = new Meal("Lunch"); 
		Meal d1 = new Meal("Dinner");
		Meal o1 = new Meal("Other");
    	
		Meal b2 = new Meal("Breakfast");
		Meal l2 = new Meal("Lunch"); 
		Meal d2 = new Meal("Dinner");
		Meal o2 = new Meal("Other");
    	
		Meal b3 = new Meal("Breakfast"); 
		Meal l3 = new Meal("Lunch"); 
		Meal d3 = new Meal("Dinner");
		Meal o3 = new Meal("Other"); 
		
		meals1.addAll(Arrays.asList(b1, l1, d1, o1));
		for (Meal meal : meals1) {
			p1.addMeal(meal);
		}
		
		meals2.addAll(Arrays.asList(b2, l2, d2, o2));
		for (Meal meal : meals2) {
			p2.addMeal(meal);
		}
		
		meals3.addAll(Arrays.asList(b3, l3, d3, o3));
		for (Meal meal : meals3) {
			p3.addMeal(meal);
		}
	}
	
// Return Profile object corresponding to the given int. 
	public Profile selectProfile(int i){
		if(i == 1){
			return this.p1;
		}
		else if(i == 2){
			return this.p2;
		}
		else if(i == 3){
			return this.p3;
		}
		else{
			System.out.println("WARNING: INVALID PROFILE SLOT, RETURNING NULL"); // Debug
			return null;
		}
	}
	
// Setters for the three Profiles
	 public void setP1(Profile p){
	    this.p1 = p;
	 }
	 public void setP2(Profile p){
		this.p2 = p;
	 }
	 public void setP3(Profile p){
		this.p3 = p;
	 }
        
// Copies profile q's information to Profile w, using copy constructors
    public void copyProfile(int q, int w){
        Profile temp = new Profile(this.selectProfile(q));
        if(w == 1){
        	this.setP1(temp);
        }
        else if(w == 2){
        	this.setP2(temp);
        }
        else if(w == 3){
        	this.setP3(temp);
        }
        else{
        	System.out.println("WARNING: COPY FAILED, INVALID PROFILE SLOT"); // Debug
        }
    }
    
// Get Meal object from given Profile
    public Meal getMeal(Profile p, String mealName){
        return p.getMeal(mealName);
    }
    
    public void createProfile(int i, String profileName){
        Profile temp = new Profile(profileName);
        
        Meal b = new Meal("Breakfast");
        Meal l = new Meal("Lunch");
        Meal d = new Meal("Dinner");
        Meal o = new Meal("Other");
        
        ArrayList<Meal> tempList = new ArrayList<Meal>();
        
        tempList.addAll(Arrays.asList(b, l, d, o));
        
        for(Meal m : tempList){
        	temp.addMeal(m);
        }
        
        if(i == 1){
        	this.setP1(temp);
        }
        else if(i == 2){
        	this.setP2(temp);
        }
        else if(i == 3){
        	this.setP3(temp);
        }
    }
    
// Create a Meal object
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