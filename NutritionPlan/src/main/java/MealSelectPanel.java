import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Creates a meal selection panel to choose a meal from. Also allows the Swing Gui
 * to return to profile selection.
 * @author DZB
 *
 */
public class MealSelectPanel {
	private SwingGui parent;
	private JPanel mealSelectPanel;
	private JButton selectBreakfast;
	private JButton selectLunch;
	private JButton selectDinner;
	private JButton selectOther;
	private JButton backToProfile;
	private JTextField mealMessage;
	
	/**
	 * Creates a MealSelectPanel with the input Swing Gui as the parent.
	 * @param SwingGui The parent frame of this panel.
	 */
	public MealSelectPanel(SwingGui theParent){
		parent = theParent;
		createPanel(parent);
	}
	
	/**
	 * Instantiates and then assigns the buttons, text fields, and action listeners for
	 * the panel.
	 * @param SwingGui The parent of this panel.
	 */
}
