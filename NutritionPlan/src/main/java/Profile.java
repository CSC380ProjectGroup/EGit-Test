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
}
