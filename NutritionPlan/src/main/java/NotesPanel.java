import javax.swing.*;
import javax.swing.SwingUtilities.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A panel to manage updating and displaying notes for a meal.
 * @author DZB
 *
 */
public class NotesPanel {
	private SwingGui parent;
	private JPanel notesPanel;
	private JPanel textPanel;
	private JPanel buttonsPanel;
	private JTextField notes;
	private JTextField notesMessage;
	private JButton submitNote;
	private JButton backToMeal;
	
	/**
	 * Instantiates the widgets for this class and creates a new NotesPanel.
	 * @param SwingGui Parent frame of this class.
	 */
	public NotesPanel(SwingGui p){
		parent = p;
		createPanel(p);
	}
	
	/**
	 * Actually instantiates the widgets, and adds them all to the panel.
	 * @param SwingGui Parent frame for this class.
	 */
	private void createPanel(SwingGui p){
		notesPanel = new JPanel(new BorderLayout());
		textPanel = new JPanel(new FlowLayout());	
		buttonsPanel = new JPanel(new FlowLayout());
		
		notes = new JTextField("Empty.");
		notesMessage = new JTextField("Please review the notes for this meal. If need be, enter a note or edit the current note.");
		
		notes.setEditable(true);
		
		submitNote = new JButton("Submit");
		backToMeal = new JButton("Back");
		
		textPanel.add(notesMessage);
		textPanel.add(notes);
		
		buttonsPanel.add(submitNote);
		buttonsPanel.add(backToMeal);
		
		notesPanel.add(textPanel, BorderLayout.CENTER);
		notesPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		submitNote.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.storeMessage(notes.getText());
			}
		});
		
		backToMeal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.returnToMealDisplay();
			}
		});
	}
	
	/**
	 * Returns the panel associated with this class.
	 * @return JPanel
	 */
	public JPanel getPanel(){
		return notesPanel;
	}
	
}
