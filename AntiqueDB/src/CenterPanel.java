import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
	
	WestPanel west;
	EastPanel east;
	SouthPanel south;
	
	public CenterPanel(WestPanel west, EastPanel east, SouthPanel south) {
		super();
		this.west = west;
		this.east = east;
		this.south = south;
		makePanel();
	}
	
	public void makePanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JButton b1 = new JButton("Move Right");
		JButton b2 = new JButton(" Move Left ");
		
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(b1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		this.add(b2, gc);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = west.getListModel().size() - 1; i >= 0; i--) {
					for(int j = 0; j < west.getSelectedAntiques().size(); j++){
						if(west.getListModel().get(i).equals(west.getSelectedAntiques().get(j))) {
							
							System.out.println(west.getSelectedAntiques());
							east.getListModel().addElement(west.getSelectedAntiques().get(j));
							west.getListModel().remove(i);
						}
					}
				}
				
			}
			
		});

	}
}
