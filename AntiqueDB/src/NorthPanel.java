import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthPanel extends JPanel{

	ArrayList<Item> itemList;
	public NorthPanel(ArrayList<Item> theItemList) {
		
		super();
		this.itemList = theItemList;
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new FlowLayout());
		JButton b1 = new JButton("Add");
		JButton b2 = new JButton("Edit");
		JButton b3 = new JButton("Delete");
		JButton b4 = new JButton("Filter");
		JButton b5 = new JButton("Sort");
		JButton b6 = new JButton("Save As");
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Iterator<Item> itr = itemList.iterator();
				while(itr.hasNext()) {
					System.out.println("Printing from WestPanel = " + itr.next().toString());
				}
				
			}
			
		});
	}
}
