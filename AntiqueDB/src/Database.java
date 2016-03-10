import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Database {
	
	public static int myWidth = 600;
	public static int myHeight = 800;
	public static JFrame frame;

	public Database() {
		//create Frame
		frame = new JFrame("AntiqueDB");
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(myWidth,myHeight));
		frame.setLocationRelativeTo(null);

		createLogoPanel();
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	public static void createLogoPanel() {
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("antique-trader-logo.jpg"));
		} catch (IOException e) {
		}
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
		logoPanel.add(logoLabel);
		frame.add(logoPanel, BorderLayout.NORTH);		
	}

}
































