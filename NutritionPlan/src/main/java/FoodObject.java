import java.util.*;

/**
* Class representing a single food object
* @author Brandon
*/

public class FoodObject {

// Global variables
	private String name, type; // name and type of food
	private int cal; // total calories, based on quantity
	private ArrayList<String> alg; // list of ingredients concerning allergies
	private int quantity; // quantity of that food object

// Constructor
	public FoodObject() {
		name = null;
		type = null;
		cal = 0;
		alg = new ArrayList<String>();
		quantity = 1; //quantity should never be zero. this breaks adjustCal(), and there's no reason for it to be zero any way
	}

// Parameterized Constructor
	public FoodObject(String n, String t, int c, ArrayList<String> a, int q) {
		name = n;
		type = t;
		cal = c;
		alg = a;
		quantity = q;
	}
	
// Copy Constructor
	public FoodObject(FoodObject dup){
		System.out.println("Running food copy constructor...");
		this.name = dup.getName();
		this.type = dup.getType();
		this.cal = dup.getCal();
		this.alg = dup.getAlg();
		this.quantity = dup.getQuantity();
	}

// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	public ArrayList<String> getAlg() {
		return alg;
	}

	public void setAlg(ArrayList<String> alg) {
		this.alg = alg;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.adjustCal(quantity);
		this.quantity = quantity;
	}
	
// Methods
	
	// Adjust total calories based on quantity
	public void adjustCal(int s) {
		int temp = s * this.cal;
		this.setCal(temp / this.quantity);           
	}
	
	// Check for valid calorie value
	public boolean checkCal(int x) {
		if (x < 0)
			return false;
		else
			return true;
	}

	// Check if food contains any allergies
	public boolean checkAlg() {
		if (this.alg.isEmpty()) {
			return false;
		} else
			return true;
	}
	
	//Check if food contains a particular allergy
		public boolean findAlg(String s){
			for(String a : this.alg){
				if(a.equals(s)){
					return true;
				}
			}
			return false;
		}
	
	// Add an allergy to the list
	public void addAlg(String s) {
		this.alg.add(s);
	}

	// Return a string that lists all of the food's allergies
	public String printAlg(){
		StringBuilder sb = new StringBuilder();
		if(this.getAlg().isEmpty()){
			return "None.";
		}
		else{
			for(String s : this.alg){
				sb.append(s + ", ");
			}
		}
		return sb.toString();
	}
	
	
	// Return string containing all information for the food
	public String toString(){
		return "NAME: " + getName() +
				"\nTYPE: " + getType() +
				"\nCALORIES: " + getCal() +
				"\nQUANTITY: " + getQuantity() +
				"\nALLERGIES: " + printAlg();
	}

}
