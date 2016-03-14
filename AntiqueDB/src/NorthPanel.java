import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
				String itemName = JOptionPane.showInputDialog("Input Item Name");
				
				while(true) {
					boolean condition = true;
					for(Item e: itemList ) {
						if(e.itemName.equals(itemName) || itemName.equals("")) {
							itemName = JOptionPane.showInputDialog("Input Item Name");
							condition = false;
							continue;
						}
					}
					if(condition) {
						break;
					}
				}

				String maker = JOptionPane.showInputDialog("Enter Maker Name");
				while(true) {
					if(!maker.equals("")) {
						break;
					} else {
						maker = JOptionPane.showInputDialog("Enter Maker Name");
					}
				}
				String date = JOptionPane.showInputDialog("Enter Date Made");
				while(true) {
					if(!date.equals("")) {
						break;
					} else {
						date = JOptionPane.showInputDialog("Enter Date Made");
					}
				}
				String description = JOptionPane.showInputDialog("Enter Item Description");
				while(true) {
					if(!description.equals("")) {
						break;
					} else {
						description = JOptionPane.showInputDialog("Enter Item Description");
					}
				}

				int ID = -1;
				for(int i = 0; i < itemList.size(); i++) {
					if(itemList.get(i).ID != i) {

						ID = i;
						break;
					}
				}
				if(ID == -1) {
					ID = itemList.size();
				}
				
				Item newItem = new Item(ID, itemName, maker, date, description);
				itemList.add(newItem);
				
				for(Item e: itemList) {
					System.out.println(e.toString());
				}
				

			}

		});
	}
}
