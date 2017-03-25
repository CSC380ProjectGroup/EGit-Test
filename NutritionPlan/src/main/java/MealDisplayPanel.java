import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList; // Not used in this current barebones implementation.
///test
/**
 * Creates and stores a panel for the displaying of a meal's information
 * in a SwingGui object.
 * @author DZB
 *
 */
public class MealDisplayPanel {
	private JPanel mealDisplayPanel;
	private JTextField foodList;
	private JTextField allergensList;
	private JTextField totalCals;
	private Meal currentMeal;
	private JButton displayNotes;
	private JButton returnToMealSelect;
	private SwingGui parent;
	private JPanel buttonsPanel;
	private JPanel textPanel;
	
	//Needs a method to set the meal and update the panel.
	
	/**
	 * Creates a meal display panel with a SwingGui as the parent frame, 
	 * and a meal to pull information from.
	 * @param SwingGui The parent frame for this panel.
	 * @param Meal The meal to pull the food information from.
	 */
	public MealDisplayPanel(SwingGui thisParent, Meal thisMeal){
		currentMeal = thisMeal;
		parent = thisParent;
		createPanel(thisParent);
	}
	
	/**
	 * Creates and instantiates all of the buttons, panels, and text fields for 
	 * the panel.
	 * @param SwingGui the parent frame for the application.
	 */
	private void createPanel(SwingGui p){
		//Not fully implemented, needs to be integrated with the database,
		//And this implementation needs to be modified to 
		//Actually read the information in the meal.
		mealDisplayPanel = new JPanel();
		mealDisplayPanel.setLayout(new BorderLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		textPanel = new JPanel(new FlowLayout());
		
		foodList = new JTextField("This is where the list of food should go.");
		allergensList = new JTextField("This is where the allergens list should go.");
		totalCals = new JTextField("This is where the list of calories should go.");
		displayNotes = new JButton("Display Notes. Not functional at the moment.");
		returnToMealSelect = new JButton("Back.");
		
		mealDisplayPanel.add(textPanel, BorderLayout.CENTER);
		mealDisplayPanel.add(buttonsPanel, BorderLayout.SOUTH);
		textPanel.add(totalCals);
		textPanel.add(allergensList);
		textPanel.add(foodList);
		buttonsPanel.add(displayNotes);
		buttonsPanel.add(returnToMealSelect);
		
		returnToMealSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealSelect();
			}
		});
	}
	
	/**
	 * Returns the panel associated with this class.
	 * @return JPanel
	 */
	public JPanel getPanel(){
		return mealDisplayPanel;
	}
}
