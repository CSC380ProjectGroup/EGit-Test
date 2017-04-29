import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Creates a panel to handle creating a new profile and copying a profile to another profile.
 * @author DZB
 *
 */
public class CreateProfilePanel {
	private SwingGui parent;
	private JPanel profilePanel;
	private JPanel textPanel;
	private JPanel buttonsPanel;
	private JPanel swapPanel;
	private JPanel choicePanel;
	private JPanel copyPanel;
	private JPanel createPanel;
	private JTextField message;
	private JTextField profileNameBox;
	private JButton backToProfiles;
	private JButton createPOne;
	private JButton createPTwo;
	private JButton createPThree;
	private JButton copyPOne;
	private JButton copyPTwo;
	private JButton copyPThree;
	private JButton toPOne;
	private JButton toPTwo;
	private JButton toPThree;
	private JButton chooseCreate;
	private JButton chooseCopy;
	private JButton submitCreate;
	private JButton submitCopy;
	private CardLayout layout;
	private int createInt;
	private int copyIntOne;
	private int copyIntTwo;
	
	
	/**
	 * Creates a single CreateProfile class.
	 * @param SwingGui the parent frame of this class.
	 */
	public CreateProfilePanel(SwingGui p){
		createInt = 0;
		copyIntOne = 0;
		copyIntTwo = 0;
		parent = p;
		createPanel(p);
	}
	
	/**
	 * Instantiates and assigns the widgets for this panel.
	 * @param SwingGui The parent frame for this panel.
	 */
	private void createPanel(SwingGui p){
		profilePanel = new JPanel(new BorderLayout());
		textPanel = new JPanel(new FlowLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		layout = new CardLayout();
		swapPanel = new JPanel(layout);
		choicePanel = new JPanel(new FlowLayout());
		copyPanel = new JPanel(new FlowLayout());
		createPanel = new JPanel(new FlowLayout());
		
		message = new JTextField("Please select whether you'd like to create or copy a profile.");
		message.setEditable(false);
		profileNameBox = new JTextField("Enter name here");
		
		backToProfiles = new JButton("Back");
		createPOne = new JButton("Profile 1");
		createPTwo = new JButton("Profile 2");
		createPThree = new JButton("Profile 3");
		copyPOne = new JButton("Profile 1");
		copyPTwo = new JButton("Profile 2");
		copyPThree = new JButton("Profile 3");
		toPOne = new JButton("Profile 1");
		toPTwo = new JButton("Profile 2");
		toPThree = new JButton("Profile 3");
		chooseCopy = new JButton("Copy one profile to another");
		chooseCreate = new JButton("Create a new profile");
		submitCreate = new JButton("Submit");
		submitCopy = new JButton("Submit");
		
		textPanel.add(message);
		swapPanel.add(choicePanel, "choicePanel");
		swapPanel.add(copyPanel, "copyPanel");
		swapPanel.add(createPanel, "createPanel");
		choicePanel.add(chooseCopy);
		choicePanel.add(chooseCreate);
		copyPanel.add(copyPOne);
		copyPanel.add(copyPTwo);
		copyPanel.add(copyPThree);
		copyPanel.add(toPOne);
		copyPanel.add(toPTwo);
		copyPanel.add(toPThree);
		copyPanel.add(submitCopy);
		createPanel.add(profileNameBox);
		createPanel.add(createPOne);
		createPanel.add(createPTwo);
		createPanel.add(createPThree);
        createPanel.add(submitCreate);
		buttonsPanel.add(backToProfiles);
		profilePanel.add(textPanel, BorderLayout.NORTH);
		profilePanel.add(swapPanel, BorderLayout.CENTER);
		profilePanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		backToProfiles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				layout.show(swapPanel, "choicePanel");
				parent.displayProfileSelect();
			}
		});
		chooseCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				layout.show(swapPanel, "copyPanel");
				message.setText("Please choose the profile to copy from, and then the profile to copy to.");
			}
		});
		chooseCreate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				layout.show(swapPanel, "createPanel");
				message.setText("Enter the name of the profile, and then select which profile slot to use.");
			}
		});
		createPOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createInt = 1;
			}
		});
		createPTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createInt = 2;
			}
		});
		createPThree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createInt = 3;
			}
		});
		submitCreate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.createNewProfile(createInt, profileNameBox.getText());
				createInt = 0;
				profileNameBox.setText("Enter profile name here.");
				layout.show(swapPanel, "choicePanel");
			}
		});
		copyPOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntOne = 1;
			}
		});
		copyPTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntOne = 2;
			}
		});
		copyPThree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntOne = 3;
			}
		});
		toPOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntTwo = 1;
			}
		});
		toPTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntTwo = 2;
			}
		});
		toPThree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyIntTwo = 3;
			}
		});
		submitCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.copyProfile(copyIntOne, copyIntTwo);
				copyIntOne = 0;
				copyIntTwo = 0;
				layout.show(swapPanel, "choicePanel");
			}
		});
	}
	
	/**
	 * Returns the panel for this class.
	 * @return JPanel
	 */
	public JPanel getPanel(){
		return profilePanel;
	}
}
