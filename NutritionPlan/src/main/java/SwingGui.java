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



	public void selectProfile(int i) {
		// TODO Change the method so it actually selects a profile properly.
		//Currently just changes the panels.
		layout.show(controlPanel, "selectPanel");
	}



	public void createAProfile() {
		// Currently just displays the create a profile panel.
		layout.show(controlPanel, "createPanel");
	}



	public void selectMeal(int i) {
		// TODO Make the method actually select the meal to use. Currently, just swaps panels.
		
		layout.show(controlPanel, "displayPanel");
	}


	/**
	 * Displays the profile select panel, returning from the meal select panel.
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



	public void returnToMealDisplay() {
		layout.show(controlPanel, "displayPanel");
	}
	
	/**
	 * Displays the current meal.
	 */
	public void displayMeal(){
		layout.show(controlPanel, "displayPanel");
	}



	public void searchFood(String text) {
		//Does nothing. Absolutely nothing right now. 
		
	}


	/**
	 * Should add a food to the database, based on the input strings.
	 * @param text
	 * @param text2
	 * @param text3
	 */
	public void addFood(String text, String text2, String text3) {
		// Does ABSOLUTELY nothing right now, besides updating and displaying the message panel.
		msgdp.setMessage(0);
		layout.show(controlPanel, "messagePanel");
	}
	
	/**
	 * Shows the notes panel for the current meal.
	 */
	public void displayNotesPanel(){
		layout.show(controlPanel, "notesPanel");
	}
	
	/**
	 * Stores the note from the notes panel into the current meal.
	 * @param String The text to store.
	 */
	public void storeMessage(String str){
		//Does not store the message yet. Will store it soon.
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
	 * Creates a new profile by taking in a control int to decide which slot to use,
	 * and a string to use as its name.
	 * @param int The slot to use for the profile.
	 * @param String The name of the profile.
	 */
	public void createNewProfile(int whichProfile, String name){
		//Does absolutely nothing yet.
	}
	
	/**
	 * Copies one profile to another, completely, using ints to determine which profiles to copy.
	 * @param int The profile to copy.
	 * @param int The profile slot to copy to.
	 */
	public void copyProfile(int whichProfile, int whichSlot){
		//Does absolutely nothing yet.
	}
	
}
