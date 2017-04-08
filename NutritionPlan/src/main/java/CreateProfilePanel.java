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
	private JTextField message;
	private JButton backToProfiles;
	
	/**
	 * Creates a single CreateProfile class.
	 * @param SwingGui the parent frame of this class.
	 */
	public CreateProfilePanel(SwingGui p){
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
		
		message = new JTextField("This panel does nothing currently.");
		
		backToProfiles = new JButton("Back");
		
		textPanel.add(message);
		buttonsPanel.add(backToProfiles);
		
		profilePanel.add(textPanel, BorderLayout.CENTER);
		profilePanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		backToProfiles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.displayProfileSelect();
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
