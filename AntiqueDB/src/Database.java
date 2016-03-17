import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Database extends JFrame{
	
	public static int myWidth = 600;
	public static int myHeight = 800;
	ArrayList<Item> itemList;
	public Database(HashMap userMap, ArrayList<Item> theItemList) {
		super();
		this.itemList = theItemList;
		createWindow();
	}
	
	public void createWindow() {
		//create Frame
		this.setTitle("Antique Trader Database");
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(myWidth,myHeight));
		this.setLocationRelativeTo(null);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); //this.DISPOSE_ON_CLOSE  switch this in later

		LogoPanel logo = new LogoPanel();
		this.add(logo, BorderLayout.NORTH);
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout());
		this.add(backPanel, BorderLayout.CENTER);
		

		
		WestPanel west = new WestPanel(this.itemList);
		backPanel.add(west, BorderLayout.WEST);
		
		SouthPanel south = new SouthPanel(this.itemList);
		backPanel.add(south, BorderLayout.SOUTH);
		
		EastPanel east = new EastPanel(this.itemList);
		backPanel.add(east, BorderLayout.EAST);
		
		CenterPanel center = new CenterPanel(west, east, south, this.itemList);
		backPanel.add(center, BorderLayout.CENTER);
		
		NorthPanel north = new NorthPanel(this.itemList, center);
		backPanel.add(north, BorderLayout.NORTH);
		
	}

}
































