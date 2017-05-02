import java.util.ArrayList;

/**
 *
 * @author Thomas
 */

public class Meal {
	
// Instance Variables
    private int totalCalories;
    private String type;
    private String notes;
    ArrayList<FoodObject> foods;
    
// Default Constructor
    public Meal() {
        totalCalories = 0;
        notes = "";
        foods = new ArrayList<FoodObject>();
        type = "";
    }
    
// Constructor for establishing Meal type only
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
    
// Getters and Setters
    public int getTotalCalories() {
        return totalCalories;
    }
    public void setTotalCalories(int c) {
        totalCalories = c;
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
	
	/**
	 * Returns the size of the food array to determine if a meal is full.
	 * @param int
	 */
	public int getMealSize(){
		return foods.size();
	}

// Methods
	
	// Remove a Food object from the list
	public void removeFood(FoodObject food) {
        if (foods.contains(food)) {
            foods.remove(food);
            totalCalories = totalCalories - food.getCal();
        }else{
            System.out.println("Not part of meal");
        }
    }
	
	// Return list of all Foods in the meal
	public ArrayList<FoodObject> getListOfFood(){
		return this.foods;
	}
    
	// Return a String listing all of the FoodObjects in the meal
	public String giveFood(){
		StringBuilder sb = new StringBuilder();
		if(this.foods.isEmpty()){
			return "None.";
		}
		else{
			for(FoodObject f : this.foods){
				sb.append(f.getName() + ", ");
			}
		}
		return sb.toString();
	}
	
	// Return a Food in the Meal with a matching name, otherwise return null
	public FoodObject scanFood(String n) {
		for (FoodObject f : this.foods) {
			if (f.getName().equals(n)) {
				return f;
			}
		}
		System.out.println("DEBUG: Food object not found, returning null");
		return null;
	}
	
	// Return a String listing all Allergies in the entire Meal
	public String getAllAlg() {
		StringBuilder sb = new StringBuilder();
		if (this.getListOfFood().isEmpty()) {
			return "None.";
		} else {
			for (int i = 0; i < this.getListOfFood().size(); i++) {
				String temp = this.getListOfFood().get(i).printAlg();
				if (!temp.equals("None.")) {
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
