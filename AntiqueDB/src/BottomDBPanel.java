import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class BottomDBPanel extends JPanel{

	public BottomDBPanel() {
		super();
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel label = new JLabel("label");
		JPanel back = new JPanel();
		back.add(label);
		this.add(back, BorderLayout.NORTH);
		
		
		String abc[] = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
		
		JPanel third = new JPanel();
		JList itemList = new JList(abc);
		itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		itemList.setLayoutOrientation(JList.VERTICAL);
		itemList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(itemList);
		listScroller.setPreferredSize(new Dimension(570, 300));
		
		JPanel backPanel = new JPanel();
		backPanel.add(listScroller);
		this.add(backPanel, BorderLayout.CENTER);
	}
}
