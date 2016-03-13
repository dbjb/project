import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthDBPanel extends JPanel{

	public NorthDBPanel() {
		
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new FlowLayout());
		JButton b1 = new JButton("Add");
		JButton b2 = new JButton("Edit");
		JButton b3 = new JButton("Delete");
		JButton b4 = new JButton("Filter");
		JButton b5 = new JButton("Export");
		JButton b6 = new JButton("Print");
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
	}
}
