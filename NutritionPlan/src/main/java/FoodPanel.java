import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Creates a panel that either allows someone to add a food to the database, or
 * simply displays a food based on how the panel is accessed.
 * @author DZB
 *
 */
public class FoodPanel {
	private SwingGui parent;
	private JPanel foodPanel;
	private JPanel infoPanel;
	private JPanel buttonsControlPanel;
	private JPanel addFoodButtons;
	private JPanel displayFoodButtons;
	private JTextField foodName;
	private JTextField calories;
	private JTextField allergens;
	private JTextField infoMessage;
	private JButton returnToMeal1;
	private JButton returnToMeal2;
	private JButton searchForFood;
	private JButton addFood;
	private JButton addFoodToMeal;
	private CardLayout layout;
	private FoodObject foodToDisplay;
	
	/**
	 * Creates a FoodPanel object and instantiates all of its widgets.
	 * @param SwingGui the parent frame for this object.
	 */
	public FoodPanel(SwingGui p){
		foodToDisplay = new FoodObject();
		parent = p;
		createPanel(p);
	}
	
	/**
	 * Instantiates all of the widgets for the panel and adds them together.
	 * @param SwingGui the parent frame for this panel. 
	 */
	private void createPanel(SwingGui p){
		
		foodPanel = new JPanel(new BorderLayout());
		infoPanel = new JPanel(new FlowLayout());
		layout = new CardLayout();
		buttonsControlPanel = new JPanel(layout);
		addFoodButtons = new JPanel(new FlowLayout());
		displayFoodButtons = new JPanel(new FlowLayout());
		
		infoMessage = new JTextField("Empty Message.");
		foodName = new JTextField("Name of Food.");
		foodName.setEditable(true);
		calories = new JTextField("Calories");
		allergens = new JTextField("Allergens");
		
		returnToMeal1 = new JButton("Back");
		returnToMeal2 = new JButton("Back");
		searchForFood = new JButton("Search");
		addFood = new JButton("Add Food");
		addFoodToMeal = new JButton("Add Food to Meal");
		
		addFoodButtons.add(returnToMeal1);
		addFoodButtons.add(addFood);
		
		displayFoodButtons.add(returnToMeal2);
		displayFoodButtons.add(searchForFood);
		displayFoodButtons.add(addFoodToMeal);
		
		buttonsControlPanel.add(addFoodButtons, "addFood");
		buttonsControlPanel.add(displayFoodButtons, "displayFood");
		
		infoPanel.add(infoMessage);
		infoPanel.add(foodName);
		infoPanel.add(calories);
		infoPanel.add(allergens);
		
		foodPanel.add(infoPanel, BorderLayout.CENTER);
		foodPanel.add(buttonsControlPanel, BorderLayout.SOUTH);
		
		returnToMeal1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealSelect();
			}
		});
		returnToMeal2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.displayMeal();
			}
		});
		searchForFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.searchFood(foodName.getText());
			}
		});
		addFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.addFood(foodName.getText(), calories.getText(), allergens.getText());
			}
		});
		addFoodToMeal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.addFoodToMeal(foodToDisplay);
			}
		});
	}
	
	/**
	 * Returns the panel associated with this class.
	 * @return JPanel
	 */
	public JPanel getPanel(){
		return foodPanel;
	}
	
	/**
	 * Sets the state of the panel. Inputting 1 sets the panel to search for a food,
	 * inputting a 2 sets the panel to add a food.
	 * @param int The control int.
	 */
	public void setPanelView(int i){
		if(i == 1){
			infoMessage.setText("To search for a food, please enter the food's name and hit Search.");
			calories.setEditable(false);
			allergens.setEditable(false);
			foodName.setText("Enter food name");
			calories.setText("Calories");
			allergens.setText("Allergens");
			layout.show(buttonsControlPanel, "displayFood");
		}
		else if(i == 2){
			infoMessage.setText("To add a food, enter the food's name, the calories it has, and the allergens.");
			allergens.setText("When adding an allergen, separate them by a comma and one space.");
			calories.setEditable(true);
			allergens.setEditable(true);
			calories.setText("Enter calories here.");
			foodName.setText("Enter food name here.");
			layout.show(buttonsControlPanel, "addFood");
		}
	}
	
	/**
	 * Sets the panel to display the current food object, when searching for a food 
	 * add to the meal.
	 */
	public void setFoodForSearch(FoodObject temp){
		foodToDisplay = temp;
		String calString = ""+temp.getCal();
		calories.setText(calString);
		allergens.setText(temp.printAlg());
	}
}

