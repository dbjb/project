import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EastPanel extends JPanel{
	
	ArrayList<Item> itemList;
	public EastPanel(ArrayList<Item> theItemList) {
		super();
		this.itemList = theItemList;
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Selected Items");
		JPanel back = new JPanel();
		back.add(label1);
		this.add(back, BorderLayout.NORTH);
		
		String abc[] = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
		
		JPanel third = new JPanel();
		JList itemList = new JList(abc);
		itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		itemList.setLayoutOrientation(JList.VERTICAL);
		itemList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(itemList);
		listScroller.setPreferredSize(new Dimension(288, 150));
		
		JPanel backPanel = new JPanel();
		backPanel.add(listScroller);
		this.add(backPanel, BorderLayout.CENTER);
		
		JButton button = new JButton("<== Move Left");
		JPanel back2 = new JPanel();
		back2.add(button);
		this.add(back2, BorderLayout.SOUTH);
	}

}
