import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.WindowConstants;

public class Main {
	
	public static int myWidth = 600;
	public static int myHeight = 800;
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
	
	public static void stopEclipeFromRunning() {
		
	}
	
	public static void createLoginPanel() {	
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
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(10, 80, 80, 25);
		panel.add(registerButton);
		
		JButton loginButton = new JButton("login");
		panel.add(loginButton);
		loginButton.setBounds(180, 80, 80, 25);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Database dataPage = new Database();
			}
		});

		
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
































