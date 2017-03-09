import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas
 */

public class Meal {
    //instance variables
    int totalCalories;
    Date mealDate = new Date();
    String type;
    String notes;
    ArrayList<FoodObject> foods;
    
    //constructor
    public Meal() {
        totalCalories = 0;
        mealDate = null;
        notes = "";
        foods = null;
        type = "";
    }
    
    //constructor for main
    public Meal(String t){
    	totalCalories = 0;
        mealDate = null;
        notes = "";
        foods = null;
    	type = t;
    }
    
    //parameterized constructor
    public Meal(ArrayList<FoodObject> items, String n, int totalCal, Date d, String t) {
        totalCalories = totalCal;
        notes = n;
        foods = items;
        mealDate = d;
        type = t;
    }
    
    //methods
    public int getTotalCalories() {
        return totalCalories;
    }
    public Date getMealDate() {
        return mealDate;
    }
    public void setMealDate(Date date) {
        mealDate = date;
    }
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

	public void removeFood(FoodObject food) {
        if (foods.contains(food)) {
            foods.remove(food);
            totalCalories = totalCalories - food.getCal();
        }else{
            System.out.println("Not part of meal");
        }
    }
    
}
