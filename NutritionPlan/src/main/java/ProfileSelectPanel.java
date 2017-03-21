import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A specific class to represent the profile selection panel of the GUI.
 * @author DZB
 * Testing 123
 */
public class ProfileSelectPanel{
	private SwingGui parent;
	private JPanel profilePanel;
	private JButton selectProfile1;
	private JButton selectProfile2;
	private JButton selectProfile3;
	private JButton createNewProfile;
	private JTextField profileOneText;
	private JTextField profileTwoText;
	private JTextField profileThreeText;
	private JTextField profileDisplayMessage;
	
	/**
	 * Creates a profile selection panel using a Swing Gui object as a parent object.
	 * @param SwingGui The parent frame of this panel.
	 */
	public ProfileSelectPanel(SwingGui theParent){
		parent = theParent;
		createPanel(theParent);
	}
	
	/**
	 * Instantiates and assigns the buttons and text fields for the profile select panel.
	 * @param SwingGui The parent frame of this panel.
	 */
	private void createPanel(SwingGui p){
		profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout());
		selectProfile1 = new JButton("Select this profile.");
		selectProfile2 = new JButton("Select this profile.");
		selectProfile3 = new JButton("Select this profile.");
		createNewProfile = new JButton("Create a new profile.");
		//These text fields need to be assigned the names of the profiles, once 
		//Database integration is complete.
		profileOneText = new JTextField("Profile 1.");
		profileTwoText = new JTextField("Profile 2.");
		profileThreeText = new JTextField("Profile 3.");
		profileDisplayMessage = new JTextField("Welcome! Please select a profile.");
		
		profilePanel.add(profileOneText, BorderLayout.WEST);
		profilePanel.add(selectProfile1, BorderLayout.WEST);
		profilePanel.add(profileTwoText, BorderLayout.CENTER);
		profilePanel.add(selectProfile2, BorderLayout.CENTER);
		profilePanel.add(profileThreeText, BorderLayout.EAST);
		profilePanel.add(selectProfile3, BorderLayout.EAST);
		profilePanel.add(profileDisplayMessage, BorderLayout.NORTH);
		profilePanel.add(createNewProfile, BorderLayout.SOUTH);
		
		selectProfile1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.selectProfile(1);
			}
		});
		selectProfile2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.selectProfile(2);
			}
		});
		selectProfile3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.selectProfile(3);
			}
		});
		createNewProfile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.createAProfile();
			}
		});
	}
	
	
	
}
