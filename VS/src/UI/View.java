package UI;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Tabellen.Person;
import Threads.SearchNr;
import Threads.SearchName;

/**
 * View.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 * represents the view-class
 * starts the threads and prints the results
 * 
 */
public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// textarea containing the results of the search
	private JTextArea textarea;
	// submit button
	private JButton submit;
	// quit button
	private JButton quit;
	// input field for name
	private JTextField name;
	// input field for number
	private JTextField number;

	/**
	 * Creating a view
	 */
	public View() {
		super("Testat1");
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 2));
		
		textarea = new JTextArea(5,100);
		name = new JTextField(20);
		number = new JTextField(20);
		submit = new JButton("Submit");
		quit = new JButton("Beenden");
		
		submit.addActionListener(this);
		quit.addActionListener(this);
		
		getContentPane().add(new JLabel("Name"));
		getContentPane().add(name);
		getContentPane().add(new JLabel("Number"));
		getContentPane().add(number);
		getContentPane().add(submit);
		getContentPane().add(quit);
		getContentPane().add(textarea);
		
		setVisible(true);

	}
	/**
	 * Actionlistener for submit button and quit button
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			textarea.setText("");
			
			// proof of name-textfield and starts the thread
			if (!(name.getText().equals(""))) {
				SearchName searchname = new SearchName(name.getText());
				Thread tname = new Thread(searchname);
				tname.start(); // start thread --> run-method in SearchName
				try {
					tname.join(); // join thread!
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				try {
					// add the results
					fillTextarea(searchname.getFoundNames(), name.getText());
					
				} catch (NullPointerException n) {
					System.err.print("Keine Ergebnisse");
					textarea.setText("Suche erfolglos");
				}
				
			} else {
				// if nothing entered in search input field
				textarea.setText("Keine Eingabe: Name \n");
			}
			
			// proof of number-textfield and starts the thread
			if( !(number.getText().equals("")) && isNumeric(number.getText().trim()) ) {
				SearchNr searchnr = new SearchNr(Integer.parseInt(number.getText().trim())); // parse given String number into number
				Thread tnumber = new Thread(searchnr);
				tnumber.start();  // start thread --> run-method in SearchName 
				try {
					tnumber.join(); // join!
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				// add the results
				fillTextarea(searchnr.getFoundNumbers(), number.getText());
				
			} else if(number.getText().equals("")){
				textarea.append("Keine Eingabe: Number \n");
				
			} else if(!isNumeric(number.getText())) {
				textarea.append("Number muss Integer sein \n");				
			}
			
		// exits when clicking the quit-button	
		} else if (e.getSource() == quit) {
			System.exit(0);
		}
	}
	
	
	/**
	 * proof of the given string if it is numeric
	 * @param str : value of number input field
	 * @return : true, if is it a number
	 */
	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true; 
	}
	/**
	 * Writes results into the textarea 
	 * For each Person a new line
	 * @param foundValues : list of results
	 * @param search : value of search input field (name or number)
	 */
	public void fillTextarea(ArrayList<Person> foundValues, String search) {
		if (foundValues.size() > 0 ) {
			for (int x = 0; x < foundValues.size(); x++) {
				textarea.append(foundValues.get(x).toString() + "\n");
			}
		} else {
			textarea.append("Suche nach "+ search +" war erfolglos \n");
		}
	}
}
