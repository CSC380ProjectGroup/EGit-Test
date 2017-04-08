import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas
 */

public class Meal {
	
//instance variables
    private int totalCalories;
    //Date mealDate = new Date();
    private String type;
    private String notes;
    ArrayList<FoodObject> foods;
    
//Constructors
    //Default
    public Meal() {
        totalCalories = 0;
        //mealDate = null;
        notes = "";
        foods = new ArrayList<FoodObject>();
        type = "";
    }
    
    //For Main
    public Meal(String t){
    	totalCalories = 0;
        notes = "";
        foods =  new ArrayList<FoodObject>();
    	type = t;
    }
    
    //Parameterized Constructor
    public Meal(ArrayList<FoodObject> items, String n, int totalCal, String t) {
        totalCalories = totalCal;
        notes = n;
        foods = items;
        //mealDate = d;
        type = t;
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
	public void removeFood(FoodObject food) {
        if (foods.contains(food)) {
            foods.remove(food);
            totalCalories = totalCalories - food.getCal();
        }else{
            System.out.println("Not part of meal");
        }
    }
	
	public ArrayList<FoodObject> getListOfFood(){
		return foods;
	}
    
	// return a string that lists all of the food
	public String giveFood(){
		StringBuilder sb = new StringBuilder();
		if(this.foods.isEmpty()){
			return "None.";
		}
		else{
			for(FoodObject f : this.foods){
				sb.append("[" + f.getName() + "]" + " ");
			}
		}
		return sb.toString();
	}
	
	// return food with a matching name, otherwise return null
	public FoodObject scanFood(String n){
		for(FoodObject f : this.foods){
			if(f.getName().equals(n)){
				return f;
			}
		}
			System.out.println("DEBUG: Food object not found, returning null");
			return null;
	}
	
	// return a string containing all information for the meal
	public String toString() {
		return "TYPE: " + getType() +
				"\nTOTAL CALORIES: " + getTotalCalories() +
				"\nFOOD: " + giveFood() +
				"\nNOTES: " + getNotes();
	}
}
