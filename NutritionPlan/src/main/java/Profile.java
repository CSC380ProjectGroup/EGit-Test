import java.util.ArrayList;
/**
 * A class designed to keep a track of the meal plan for a specific person.
 * @author DZB
 * 
 */
public class Profile {
	

	private String profileName;
	private ArrayList<Meal> listOfMeals;
	
/**
 * Constructs an empty, basic Profile.
 */
	public Profile(){
		profileName = "";
		listOfMeals = new ArrayList<Meal>();
	}
	
/**
 * Constructs a new Profile based on an input name.
 * @param String The name to use for the profile name.
 */
	public Profile(String name){
		profileName = name;
		listOfMeals = new ArrayList<Meal>();
	}
	
/**
 * Parameterized Constructor
 * @param name and list of meals
 */
	public Profile(String n,ArrayList<Meal> m){
		profileName = n;
		listOfMeals = m;
	}
	
/**
 * Copy Constructor
 */
	public Profile(Profile dup){
		System.out.println("Running profile copy constructor...");
		this.profileName = dup.getName();
		for(int i = 0; i < dup.getListOfMeals().size(); i++){
			this.addMeal(new Meal(dup.getListOfMeals().get(i)));
		}
	}
	
/**
 * Sets the name for this profile.
 * @param String 
 */
	public void setName(String name){
		profileName = name;
	}
	
/**
 * Returns the name of this profile.
 * @return String
 */
	public String getName(){
		return profileName;
	}
	
/**
 * Return the Array List of Meals
 */
	public ArrayList<Meal> getListOfMeals() {
		return listOfMeals;
	}
	
/**
 * Setter for listOfMeals
 */
	public void setListOfMeals(ArrayList<Meal> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
	
/**
 * Adds a meal object to the list of meals.
 * @param Meal The meal to add to the list.
 */
	public void addMeal(Meal meal){
		listOfMeals.add(meal);
	}
	
/**
 * Returns true if the list of meals is empty, false if it is not.
 * @return boolean
 */
	public boolean areMealsEmpty(){
		return listOfMeals.isEmpty();
	}
	
/**
 * Access a particular meal from the list
 * @return Meal
 */
	public Meal getMeal(String s){
		for(Meal m : this.listOfMeals){
			if(m.getType().equals(s)){
				return m;
			}
		}
		System.out.println("Could not find meal, returning a null");
		return null;
	}
}
