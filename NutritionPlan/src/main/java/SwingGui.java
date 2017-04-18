import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

//Test.???
public class SwingGui extends JFrame{
	private ProfileSelectPanel psp;
	private MealSelectPanel msp;
	private MealDisplayPanel mdp;
	private MessageDisplayPanel msgdp;
	private FoodPanel fp;
	private NotesPanel np;
	private CreateProfilePanel cpp;
	private JPanel profilePanel;
	private JPanel mealSPanel;
	private JPanel mealDPanel;
	private JPanel messageDPanel;
	private JPanel foodPanel;
	private JPanel notesPanel;
	private JPanel createPPanel;
	private Profile currentProfile;
	private Meal currentMeal;
	private CardLayout layout;
	private JPanel controlPanel;
	private Control dataStorage; // Need to instantiate data Storage.
	
	/**
	 * Creates a basic, empty SwingGui object to work off of and sets the 
	 * frame to visible.
	 */
	public SwingGui(){
		controlPanel = new JPanel(new CardLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		psp = new ProfileSelectPanel(this);
		profilePanel = psp.getPanel();
		
		msp = new MealSelectPanel(this);
		mealSPanel = msp.getPanel();
		
		msgdp = new MessageDisplayPanel(this);
		messageDPanel = msgdp.getPanel();
		
		fp = new FoodPanel(this);
		foodPanel = fp.getPanel();
		
		np = new NotesPanel(this);
		notesPanel = np.getPanel();
		
		cpp = new CreateProfilePanel(this);
		createPPanel = cpp.getPanel();
		
		//Creates a dummy meal to build the meal display panel.
		currentMeal = new Meal();
		mdp = new MealDisplayPanel(this, currentMeal);
		mealDPanel = mdp.getPanel();
		
		//Creates a dummy profile to work with at first, before the profile is selected.
		currentProfile = new Profile();
		
		layout = (CardLayout)(controlPanel.getLayout());
		
		controlPanel.add(profilePanel, "profilePanel");
		controlPanel.add(mealSPanel, "selectPanel");
		controlPanel.add(mealDPanel, "displayPanel");
		controlPanel.add(messageDPanel, "messagePanel");
		controlPanel.add(foodPanel, "foodPanel");
		controlPanel.add(notesPanel, "notesPanel");
		controlPanel.add(createPPanel, "createPanel");
		
		layout.show(controlPanel, "profilePanel");
		add(controlPanel, BorderLayout.CENTER);
		pack();
		setResizable(true);
		setVisible(true);
	}



	/**
	 * Selects the profile to use for the Gui panels, and then displays 
	 * the meal select panel for the GUI.
	 * @param i Control int to determine which profile is selected.
	 */
	public void selectProfile(int i) {
		currentProfile = dataStorage.getProfile(i);
		layout.show(controlPanel, "selectPanel");
	}


	/**
	 * Simply displays the create a profile panel.
	 */
	public void createAProfile() {
		layout.show(controlPanel, "createPanel");
	}



	/**
	 * Selects the meal from the current profile, and then updates the Meal Panel
	 * with the meal in question to allow it to display properly.
	 * Then, makes the meal panel visible.
	 * @param i Control int to determine which meal is selected.
	 */
	public void selectMeal(int i) {
		if(i == 1){
			currentMeal = currentProfile.getMeal("Breakfast");
		}
		else if(i == 2){
			currentMeal = currentProfile.getMeal("Lunch");
		}
		else if(i == 3){
			currentMeal = currentProfile.getMeal("Dinner");
		}
		else{
			currentMeal = currentProfile.getMeal("Other");
		}
		mdp.setMeal(currentMeal);
		layout.show(controlPanel, "displayPanel");
	}


	/**
	 * Displays the profile select panel, returning from another panel.
	 */
	public void displayProfileSelect() {
		layout.show(controlPanel, "profilePanel");
	}


	/**
	 * Displays the meal select panel, returning from the meal display panel.
	 */
	public void returnToMealSelect() {
		layout.show(controlPanel, "selectPanel");
	}


	/**
	 * Returns to the meal display panel from another panel.
	 */
	public void returnToMealDisplay() {
		layout.show(controlPanel, "displayPanel");
	}
	
	/**
	 * Displays the current meal.
	 */
	public void displayMeal(){
		layout.show(controlPanel, "displayPanel");
	}


	/**
	 * Searches the database for the food in question and then displays it in the food display panel.
	 * @param text The name of the food to search.
	 */
	public void searchFood(String text) {
		FoodObject temp = new FoodObject();
		//Needs to search for the food object from the database.
		fp.setFoodForSearch(temp);
	}


	/**
	 * Should add a food to the database, based on the input strings.
	 * @param text
	 * @param text2
	 * @param text3
	 */
	public void addFood(String text, String text2, String text3) {
		// Needs to create a food object and add it to the database.
		msgdp.setMessage(0);
		layout.show(controlPanel, "messagePanel");
	}
	
	/**
	 * Shows the notes panel for the current meal.
	 */
	public void displayNotesPanel(){
		np.setNote(currentMeal.getNotes());
		layout.show(controlPanel, "notesPanel");
	}
	
	/**
	 * Stores the note from the notes panel into the current meal.
	 * @param String The text to store.
	 */
	public void storeMessage(String str){
		currentMeal.setNotes(str);
		msgdp.setMessage(1);
		layout.show(controlPanel, "messagePanel");
	}
	
	/**
	 * Prepares the foodPanel for either a search or an add for food.
	 * @param int The control int for the class.
	 */
	public void selectFoodPanel(int i){
		fp.setPanelView(i);
		layout.show(controlPanel, "foodPanel");
	}
	
	/**
	 * Adds the input food to the current meal and updates the meal display panel.
	 * @param FoodObject The food to add to the meal.
	 */
	public void addFoodToMeal(FoodObject temp){
		currentMeal.addFood(temp);
		mdp.setMeal(currentMeal);
	}
	
	/**
	 * Creates a new profile by taking in a control int to decide which slot to use,
	 * and a string to use as its name.
	 * @param int The slot to use for the profile.
	 * @param String The name of the profile.
	 */
	public void createNewProfile(int whichProfile, String name){
		//This method needs to be renamed to actually interface with the Control class.
		dataStorage.createProfile(whichProfile, name);
	}
	
	/**
	 * Copies one profile to another, completely, using ints to determine which profiles to copy.
	 * @param int The profile to copy.
	 * @param int The profile slot to copy to.
	 */
	public void copyProfile(int whichProfile, int whichSlot){
		//This method needs to be renamed to actuall interface with the Control class.
		dataStorage.copyProfile(whichProfile, whichSlot);
	}


	/**
	 * Removes a food from the current meal based on the food name in the input string.
	 * @param text The name of the food to remove.
	 */
	public void removeFoodFromMeal(String text) {
		// TODO Needs to take the string, make a food object or search the database for it,
		// Then just call the remove food method for the current meal.
		
	}
	
}
