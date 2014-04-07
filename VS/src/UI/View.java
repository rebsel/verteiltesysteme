package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View extends JFrame {
	
	public View() {
		super("Testat1");
		setSize(450,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 2));
		
		
		
		getContentPane().add(new JLabel("Name"));
		getContentPane().add(new JTextField(20));
		getContentPane().add(new JLabel("Number"));
		getContentPane().add(new JTextField(20));
		getContentPane().add(new JButton("  Submit  "));
		
		getContentPane().add(new JButton("Beenden"));
		
		setVisible(true);

	}
}
