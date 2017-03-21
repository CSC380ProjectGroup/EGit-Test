import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

public class SwingGui extends JFrame implements ActionListener {
	
	// The panels used for the displays.
	private ProfileSelectPanel profilePanel;
	private JPanel mealSelectPanel;
	private JPanel mealDisplayPanel;
	private JPanel notesDisplay;
	
	// Buttons for the profile select panel.
	private JButton selectProfile1;
	private JButton selectProfile2;
	private JButton selectProfile3;
	private JButton createNewProfile;
	
	// Text fields for the profile select panel.
	private JTextField profileOneText;
	private JTextField profileTwoText;
	private JTextField profileThreeText;
	private JTextField profileDisplayMessage;
	
	// Buttons for the meal select panel.
	private JButton selectBreakfast;
	private JButton selectLunch;
	private JButton selectDinner;
	private JButton selectOther;
	private JButton backToProfile;
	
	// Text fields for the meal select panel. Tentative, not sure how much is needed.
	private JTextField mealMessage;
	
	// Buttons for the Meal Display Panel.
	private JButton diplayMealDetails;
	private JButton displayMealNotes;
	private JButton addFood;
	
	// The large JTextField for the list of food names.
	private JTextField listOfMealFood;
	
	//Information storage for the GUI.
	private Profile currentProfile;
	private Meal currentMeal;
	
	/**
	 * Creates a basic, empty SwingGui object.
	 */
	public SwingGui(){
		
		//Sets the layout of the GUI itself.
		setLayout(new BorderLayout());
		
		//Creates the panel and buttons for the Profile section of the Gui, and
		//adds the buttons to the panel.
		profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout());
		
		selectProfile1 = new JButton("Select this profile.");
		selectProfile2 = new JButton("Select this profile.");
		selectProfile3 = new JButton("Select this profile.");
		createNewProfile = new JButton("Create a new profile, or copy a current one.");
		
		//Currently, only lists profiles by number. When integrated to database should use names.
		profileOneText = new JTextField("Profile 1.");
		profileTwoText = new JTextField("Profile 2.");
		profileThreeText = new JTextField ("Profile 3.");
		profileDisplayMessage = new JTextField("Welcome! Please select a profile.");
		
		profilePanel.add(profileDisplayMessage, BorderLayout.NORTH);
		profilePanel.add(profileOneText, BorderLayout.WEST);
		profilePanel.add(selectProfile1, BorderLayout.WEST);
		profilePanel.add(profileTwoText, BorderLayout.CENTER);
		profilePanel.add(selectProfile2, BorderLayout.CENTER);
		profilePanel.add(profileThreeText, BorderLayout.EAST);
		profilePanel.add(selectProfile3, BorderLayout.EAST);
		profilePanel.add(createNewProfile, BorderLayout.SOUTH);
		
		selectProfile1.addActionListener(this);
		selectProfile2.addActionListener(this);
		selectProfile3.addActionListener(this);
		createNewProfile.addActionListener(this);
		
		//Creates the panel, buttons, and text fields for the Meal Select Panel.
		mealSelectPanel = new JPanel();
		mealSelectPanel.setLayout(new BorderLayout());
		
		selectBreakfast = new JButton("Select Breakfast.");
		selectLunch = new JButton("Select Lunch.");
		selectDinner = new JButton("Select Dinner.");
		selectOther = new JButton("Select Other.");
		backToProfile = new JButton("Return to profile select.");
		
		mealMessage = new JTextField("Please select a meal to view.");
		
		mealSelectPanel.add(mealMessage, BorderLayout.NORTH);
		mealSelectPanel.add(selectBreakfast, BorderLayout.CENTER);
		mealSelectPanel.add(selectLunch, BorderLayout.CENTER);
		mealSelectPanel.add(selectDinner, BorderLayout.CENTER);
		mealSelectPanel.add(selectOther, BorderLayout.CENTER);
		mealSelectPanel.add(backToProfile, BorderLayout.SOUTH);
		
		selectBreakfast.addActionListener(this);
		selectLunch.addActionListener(this);
		selectDinner.addActionListener(this);
		selectOther.addActionListener(this);
		backToProfile.addActionListener(this);
		
		//Creates the Meal Display Panel.
		
	}
	
}
