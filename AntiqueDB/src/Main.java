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

public class Main {
	
	public static int myWidth = 600;
	public static int myHeight = 1000;
	public static JFrame frame;

	public static void main(String[] args) {
		
		//create Frame
		frame = new JFrame("AntiqueDB");
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(myWidth,myHeight));
		frame.setLocationRelativeTo(null);

		createLogoPanel();
		createLoginPanel();
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void createLoginPanel() {
//		JPanel loginPanel = new JPanel(null);
//		JLabel loginLabel = new JLabel("Login");
//		loginLabel.setFont(new Font("Serif", Font.BOLD, 20));
//		loginLabel.setLocation(300, 100);
//		loginPanel.add(loginLabel);

		
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("register");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("login");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		
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
































