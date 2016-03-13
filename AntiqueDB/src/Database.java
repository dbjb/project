import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Database extends JFrame{
	
	public static int myWidth = 600;
	public static int myHeight = 800;

	public Database(HashMap userMap) {
		//create Frame
		this.setTitle("Antique Trader Database");
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(myWidth,myHeight));
		this.setLocationRelativeTo(null);

		LogoPanel logoPanel = new LogoPanel();
		this.add(logoPanel, BorderLayout.NORTH);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); //this.DISPOSE_ON_CLOSE  switch this in later
		
		createWindow();
	}
	
	public void createWindow() {
		JPanel databasePanel = new JPanel();
		this.add(databasePanel, BorderLayout.CENTER);
		databasePanel.setBackground(Color.BLACK);
	}

}
































