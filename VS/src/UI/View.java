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
 * 
 * TO-DO:
 * - SearchNr anpassen
 * - trimBlanks
 * - Umlaute?
 * - auf Rechner im Labor testen
 * - funktionieren ä,ü und von Reihbach?
 * - leere Eingaben, Blank oder Tabfolgen sofort abweisen und nicht Liste durchsuchen!
 * - Bei NullPointerException --> Suche erfolglos in TextArea
 * 
 * 
 * 
 */
public class View extends JFrame implements ActionListener {
	
	private JTextArea textarea;
	private JButton submit;
	private JButton quit;
	private JTextField name;
	private JTextField number;

	
	public View() {
		super("Testat1");
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 2));
		
		textarea = new JTextArea(5,100);
		name = new JTextField(20);
		number = new JTextField(20);
		submit = new JButton("  Submit  ");
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
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			textarea.setText("");
			// proof of name-textfield
			if (!(name.getText().equals(""))) {
				SearchName searchname = new SearchName(name.getText());
				Thread tname = new Thread(searchname);
				tname.start();
				try {
					tname.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					fillTextarea(searchname.getFoundNames());
				} catch (NullPointerException n) {
					System.err.print("Keine Ergebnisse");
					textarea.setText("Suche erfolglos");
				}
				// PROOF OF BLANKS!
				
			} else {
				System.out.println("Keine Eingabe: Name");
			}
			
			// proof of number-textfield
			if( !(number.getText().equals("")) && isNumeric(number.getText()) ) {
				SearchNr searchnr = new SearchNr();
				Thread tnumber = new Thread(searchnr);
				tnumber.start();
				try {
					tnumber.join();
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			} else if(!isNumeric(number.getText())) {
				System.out.println("Number muss Integer sein");
				
			} else {
				System.out.println("Keine Eingabe: Number");
			}
			
		} else if (e.getSource() == quit) {
			System.exit(0);
		}
	}
	
	public boolean isNumeric(String str) {
		try {
			int x = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true; 
	}
	
	public void fillTextarea(ArrayList<Person> foundValues) {
		for (int x = 0; x < foundValues.size(); x++) {
			textarea.append(foundValues.get(x).toString() + "\n");
		}
	}
	
	//function trimBlanks!
	
}
