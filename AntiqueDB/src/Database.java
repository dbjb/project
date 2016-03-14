import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Database extends JFrame{
	
	public static int myWidth = 600;
	public static int myHeight = 800;

	public Database(HashMap userMap) {

		super();
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
		
		NorthPanel north = new NorthPanel();
		backPanel.add(north, BorderLayout.NORTH);
		
		WestPanel left = new WestPanel();
		backPanel.add(left, BorderLayout.WEST);
		
		SouthPanel bottom = new SouthPanel();
		backPanel.add(bottom, BorderLayout.SOUTH);
		
		EastPanel right = new EastPanel();
		backPanel.add(right, BorderLayout.EAST);
		
	}

}
































