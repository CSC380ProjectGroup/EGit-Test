import java.sql.SQLException;
import java.util.*;

/**
 * Class that stores Profiles and Meal objects, pulls data, and the like
 */
public class Control {
	
	private Meal b1; 
	private Meal l1; 
	private Meal d1;
	private Meal o1; 
	
	private Meal b2; 
	private Meal l2; 
	private Meal d2;
	private Meal o2; 
	
	private Meal b3; 
	private Meal l3;
	private Meal d3;
	private Meal o3; 
	
	private ArrayList<Meal> meals1;
	private ArrayList<Meal> meals2;
	private ArrayList<Meal> meals3;

	private Profile p1;
	private Profile p2;
	private Profile p3;
        
    private ArrayList<Profile> profiles;
	
// Default Constructor
    public Control() {
    	b1 = new Meal("Breakfast");
    	l1 = new Meal("Lunch"); 
    	d1 = new Meal("Dinner");
    	o1 = new Meal("Other");
    	
    	b2 = new Meal("Breakfast");
    	l2 = new Meal("Lunch"); 
    	d2 = new Meal("Dinner");
    	o2 = new Meal("Other");
    	
    	b3 = new Meal("Breakfast"); 
    	l3 = new Meal("Lunch"); 
    	d3 = new Meal("Dinner");
    	o3 = new Meal("Other"); 

    	meals1 = new ArrayList<Meal>();
    	meals2 = new ArrayList<Meal>();
    	meals3 = new ArrayList<Meal>();
    	
    	p1 = new Profile("Profile 1");
    	p2 = new Profile("Profile 2");
    	p3 = new Profile("Profile 3");
        
        setup();
    	
    	
    }
	
	// Sets up all of the objects, to be executed in Main upon running the program
	public void setup() {
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
    
    public Meal getMeal(Profile p, String mealName){
        return p.getMeal(mealName);
    }
    
    public void createProfile(int i, String profileName){
        Profile temp = new Profile(profileName);
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