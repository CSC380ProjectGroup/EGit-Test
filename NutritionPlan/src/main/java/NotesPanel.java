import javax.swing.*;
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
	private JTextArea notes;
	private JTextField notesMessage;
	private JButton submitNote;
	private JButton backToMeal;
	private static final int TEXT_LIMIT = 1500; 
	
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
		
		notes = new JTextArea("Empty.");
		notesMessage = new JTextField("Please review the notes for this meal. If need be, enter a note or edit the current note.");
		
		notes.setEditable(true);
		notes.setLineWrap(true);
		notesMessage.setEditable(false);
		
		submitNote = new JButton("Submit");
		backToMeal = new JButton("Back");
		
		textPanel.add(notes);
		
		buttonsPanel.add(submitNote);
		buttonsPanel.add(backToMeal);
		
		notesPanel.add(notesMessage, BorderLayout.NORTH);
		notesPanel.add(notes, BorderLayout.CENTER);
		notesPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		submitNote.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String noteToAdd = notes.getText();
				if(noteToAdd.length() >= TEXT_LIMIT){
					notesMessage.setText("The current note is too large. Please reduce the size of the note.");
				}
				else{
					parent.storeMessage(noteToAdd);
				}
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
	
	
	/**
	 * Sets the note for the note panel.
	 * @param String The current note for the current meal.
	 */
	public void setNote(String str){
		notes.setText(str);
		if(str.isEmpty()){
			notes.setText("This Meal has no notes associated with it.");
		}
	}
}
