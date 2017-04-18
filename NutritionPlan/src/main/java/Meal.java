import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas
 */

public class Meal {
	
// instance variables
    private int totalCalories;
    //Date mealDate = new Date();
    private String type;
    private String notes;
    ArrayList<FoodObject> foods;
    
// Default Constructor
    public Meal() {
        totalCalories = 0;
        //mealDate = null;
        notes = "";
        foods = new ArrayList<FoodObject>();
        type = "";
    }
    
// Constructor for establishing meal type only (used in Main)
    public Meal(String t){
    	totalCalories = 0;
        notes = "";
        foods =  new ArrayList<FoodObject>();
    	type = t;
    }
    
// Parameterized Constructor
    public Meal(ArrayList<FoodObject> items, String n, int totalCal, String t) {
        totalCalories = totalCal;
        notes = n;
        foods = items;
        //mealDate = d;
        type = t;
    }
    
// Copy Constructor
    public Meal(Meal dup){
    	this.totalCalories = dup.getTotalCalories();
    	this.notes = dup.getNotes();
    	this.type = dup.getType();
    	for(FoodObject f : dup.getListOfFood()){
			this.addFood(new FoodObject(f));
		}
    }
    
// Getters and Setters
    public int getTotalCalories() {
        return totalCalories;
    }
    public void setTotalCalories(int c) {
        totalCalories = c;
    }
    
	// public Date getMealDate() {
	// return mealDate;
	// }
	// public void setMealDate(Date date) {
	// mealDate = date;
	// }
    
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void addFood(FoodObject food) {
        foods.add(food);
        totalCalories = totalCalories + food.getCal();
    }    
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

// Methods
	
	// remove a food object from the list
	public void removeFood(FoodObject food) {
        if (foods.contains(food)) {
            foods.remove(food);
            totalCalories = totalCalories - food.getCal();
        }else{
            System.out.println("Not part of meal");
        }
    }
	
	// return list of all foods in the meal
	public ArrayList<FoodObject> getListOfFood(){
		return foods;
	}
    
	// return a string listing all of the foodobjects in the meal
	public String giveFood(){
		StringBuilder sb = new StringBuilder();
		if(this.foods.isEmpty()){
			return "None.";
		}
		else{
			for(FoodObject f : this.foods){
				sb.append(f.getName() + "\n");
			}
		}
		return sb.toString();
	}
	
	// return a food in the meal with a matching name, otherwise return null
	public FoodObject scanFood(String n){
		for(FoodObject f : this.foods){
			if(f.getName().equals(n)){
				return f;
			}
		}
			System.out.println("DEBUG: Food object not found, returning null");
			return null;
	}
	
	// Return all allergies in the entire Meal
	public String getAllAlg(){
		StringBuilder sb = new StringBuilder();
    	if(this.getListOfFood().isEmpty()) {
    		return "None.";
    	}
    	else {
    		for(int i = 0; i < this.getListOfFood().size(); i++) {
    			String temp = this.getListOfFood().get(i).printAlg();
    			if(!temp.equals("None.")) {
        			sb.append(temp);
    			}
        	}
        }
    		return sb.toString();
	}
	
	// return a string containing all information for the meal
	public String toString() {
		return "TYPE: " + getType() + "\nTOTAL CALORIES: " + getTotalCalories() + "\nFOOD: " + giveFood() + "\nNOTES: "
				+ getNotes();
	}
}
