import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Creates a panel to display a message. Either displays that a note or a food was added successfully, or
 * that there was an error.
 * @author DZB
 *
 */
public class MessageDisplayPanel {
	private SwingGui parent;
	private JPanel messageDisplayPanel;
	private JPanel textPanel;
	private JPanel buttonsPanel;
	private JButton backToSelect;
	private JButton backToProfiles;
	private JButton backToMeal;
	private JTextField message;
	private CardLayout layout;
	
	/**
	 * Creates a MessageDisplayPanel and instantiates all of its widgets.
	 * @param SwingGui The parent frame of this object.
	 */
	public MessageDisplayPanel(SwingGui p){
		parent = p;
		createPanel(p);
	}
	
	/**
	 * Instantiates the widgets of the panel.
	 * @param SwingGui parent frame of this panel.
	 */
	private void createPanel(SwingGui p){
		messageDisplayPanel = new JPanel(new BorderLayout());
		textPanel = new JPanel(new FlowLayout());
		layout = new CardLayout();
		buttonsPanel = new JPanel(layout);
		backToMeal = new JButton("Back");
		backToSelect = new JButton("Back");
		backToProfiles = new JButton("Back");
		message = new JTextField("Empty");
		
		buttonsPanel.add(backToMeal, "mealDisplay");
		buttonsPanel.add(backToSelect, "selectDisplay");
		buttonsPanel.add(backToProfiles, "profilesDisplay");
		textPanel.add(message);
		
		messageDisplayPanel.add(textPanel, BorderLayout.NORTH);
		messageDisplayPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		backToMeal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealDisplay();
			}
		});
		backToSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealSelect();
			}
		});
		backToProfiles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.displayProfileSelect();
			}
		});
	}
	
	/**
	 * Sets the message to display.
	 * @param int A number to determine which message to display.
	 */
	public void setMessage(int number){
		if(number == 0){
			message.setText("Your food has been added successfully!");
			layout.show(buttonsPanel, "selectDisplay");
		}
		else if (number == 1){
			message.setText("Your note has been added successfully!");
			layout.show(buttonsPanel, "mealDisplay");
		}
		else if(number == 2){
			message.setText("The profile has been created successfully.");
			layout.show(buttonsPanel, "profileDisplay");
		}
		else{
			message.setText("Unfortunately, there was an error processing your request.");
			layout.show(buttonsPanel, "profileDisplay");
		}
	}
	
	/**
	 * Returns the panel associated with this class.
	 * @return JPanel
	 */
	public JPanel getPanel(){
		return messageDisplayPanel;
	}

}
