import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class LeftDBPanel extends JPanel{

	public LeftDBPanel() {
		super();
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Antique Item List");
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
		listScroller.setPreferredSize(new Dimension(270, 150));
		
		JPanel backPanel = new JPanel();
		backPanel.add(listScroller);
		this.add(backPanel, BorderLayout.CENTER);
		
		JButton button = new JButton("Move Right ==>");
		JPanel back2 = new JPanel();
		back2.add(button);
		this.add(back2, BorderLayout.SOUTH);
	}
}
