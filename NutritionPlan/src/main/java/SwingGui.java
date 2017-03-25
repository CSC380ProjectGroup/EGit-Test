import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

//Test.???
public class SwingGui extends JFrame{
	private ProfileSelectPanel psp;
	private MealSelectPanel msp;
	private MealDisplayPanel mdp;
	private JPanel profilePanel;
	private JPanel mealSPanel;
	private JPanel mealDPanel;
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
		// TODO Does absolutely nothing yet. Not implemented, because it will need database links.
		
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
	
}
