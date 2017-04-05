import javax.swing.*;
import javax.swing.SwingUtilities.*;
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
	private JButton backToMeal;
	private JTextField message;
	
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
		buttonsPanel = new JPanel(new FlowLayout());
		backToMeal = new JButton("Back");
		message = new JTextField("Empty");
		
		buttonsPanel.add(backToMeal);
		textPanel.add(message);
		
		messageDisplayPanel.add(textPanel, BorderLayout.NORTH);
		messageDisplayPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		backToMeal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealDisplay();
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
		}
		else if (number == 1){
			message.setText("Your note has been added successfully!");
		}
		else{
			message.setText("Unfortunately, there was an error processing your request.");
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
