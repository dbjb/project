import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WestPanel extends JPanel{

	public ArrayList<Item> itemList;
	public WestPanel(ArrayList<Item> theItemList) {
		super();
		this.itemList = theItemList;
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Antique Item List");
		JPanel back = new JPanel();
		back.add(label1);
		this.add(back, BorderLayout.NORTH);
		
		String array[] = new String[itemList.size()];
		
		for(int i = 0; i < itemList.size(); i++) {
			array[i] = itemList.get(i).itemName;
		}
		
		JPanel third = new JPanel();
		JList myList = new JList(array);
		myList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
			
		});
		myList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		myList.setLayoutOrientation(JList.VERTICAL);
		myList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(myList);
		listScroller.setPreferredSize(new Dimension(270, 150));
		
		JPanel backPanel = new JPanel();
		backPanel.add(listScroller);
		this.add(backPanel, BorderLayout.CENTER);
		
		JButton button = new JButton("Move Right ==>");
		JPanel back2 = new JPanel();
		back2.add(button);
		this.add(back2, BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Item e: itemList) {
					System.out.println(e.toString());
				}
			}
			
		});
	}
}
