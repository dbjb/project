import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SouthPanel extends JPanel{

	public SouthPanel() {
		super();
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JLabel label = new JLabel("Detailed Description");
		JPanel back = new JPanel();
		back.setLayout(new BorderLayout());
		JPanel backtop = new JPanel();
		backtop.add(label);
		back.add(backtop, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("descriptions category");
		JPanel backbottom = new JPanel();
		backbottom.add(label2);
		back.add(backbottom, BorderLayout.SOUTH);
		
		this.add(back, BorderLayout.NORTH);

		ArrayList<String> itemsArrayList = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i < 40; i++) {
			count++;
			
			itemsArrayList.add("test" + count);
		}
		
		String itemsList[] = itemsArrayList.toArray(new String[itemsArrayList.size()]);
		
		JPanel third = new JPanel();
		JList items = new JList(itemsList);
		items.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		items.setLayoutOrientation(JList.VERTICAL);
		items.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(items);
		listScroller.setPreferredSize(new Dimension(570, 300));
		
		JPanel backPanel = new JPanel();
		backPanel.add(listScroller);
		this.add(backPanel, BorderLayout.CENTER);
	}
}
