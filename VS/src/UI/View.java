package UI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View extends JFrame {
	
	public View() {
		super("Testat1");
		setSize(450,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		JLabel label = new JLabel();
		getContentPane().add(new JButton("X"));
		getContentPane().add(new JTextField(25));
		getContentPane().add(new JButton("  Submit  "));
		getContentPane().add(label);
		
		setVisible(true);

	}
}
