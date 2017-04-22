import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
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
	private JTextField foodNameToRemove;
	private Meal currentMeal;
	private JButton displayNotes;
	private JButton returnToMealSelect;
	private JButton searchFood;
	private JButton removeFood;
	private JButton commitRemove;
	private JButton cancelRemove;
	private SwingGui parent;
	private JPanel buttonsPanel;
	private JPanel removeFoodPanel;
	private JPanel buttonsControlPanel;
	private JPanel textPanel;
	private CardLayout layout;
	
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
		layout = new CardLayout();
		buttonsControlPanel = new JPanel(layout);
		buttonsPanel = new JPanel(new FlowLayout());
		removeFoodPanel = new JPanel(new FlowLayout());
		textPanel = new JPanel(new FlowLayout());
		
		foodList = new JTextField("This is where the list of food should go.");
		foodList.setEditable(false);
		allergensList = new JTextField("This is where the allergens list should go.");
		allergensList.setEditable(false);
		totalCals = new JTextField("This is where the list of calories should go.");
		totalCals.setEditable(false);
		foodNameToRemove = new JTextField("Enter the name of the food to remove here.");
		displayNotes = new JButton("Display Notes");
		searchFood = new JButton("Search Food to add to meal");
		returnToMealSelect = new JButton("Back.");
		removeFood = new JButton("Remove food from meal");
		commitRemove = new JButton("Submit");
		cancelRemove = new JButton("Cancel");
		
		mealDisplayPanel.add(textPanel, BorderLayout.CENTER);
		mealDisplayPanel.add(buttonsControlPanel, BorderLayout.SOUTH);
		textPanel.add(totalCals);
		textPanel.add(allergensList);
		textPanel.add(foodList);
		buttonsPanel.add(displayNotes);
		buttonsPanel.add(returnToMealSelect);
		buttonsPanel.add(searchFood);
		buttonsPanel.add(removeFood);
		removeFoodPanel.add(foodNameToRemove);
		removeFoodPanel.add(commitRemove);
		removeFoodPanel.add(cancelRemove);
		buttonsControlPanel.add(buttonsPanel, "buttons");
		buttonsControlPanel.add(removeFoodPanel, "removeFood");
		
		layout.show(buttonsControlPanel, "buttons");
		
		returnToMealSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealSelect();
			}
		});
		
		searchFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.selectFoodPanel(1);
			}
		});
		
		displayNotes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.displayNotesPanel();
			}
		});
		removeFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				layout.show(buttonsControlPanel, "removeFood");
			}
		});
		commitRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                            parent.removeFoodFromMeal(foodNameToRemove.getText());
                            foodNameToRemove.setText("Enter the name of the food to remove here.");
                            setMeal(currentMeal);
                            layout.show(buttonsControlPanel, "buttons");
			}
		});
		cancelRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				layout.show(buttonsControlPanel, "buttons");
				foodNameToRemove.setText("Enter the name of the food to remove here.");
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
	
	/**
	 * Sets the current meal to be the input meal, and updates the display
	 * With that information.
	 * @param Meal The meal to pull information from.
	 */
	public void setMeal(Meal temp){
		currentMeal = temp;
		allergensList.setText(currentMeal.getAllAlg());
		String totalCalories = ""+currentMeal.getTotalCalories();
		totalCals.setText(totalCalories);
		String foodDescript = currentMeal.giveFood();
		foodList.setText(foodDescript);
	}
}
