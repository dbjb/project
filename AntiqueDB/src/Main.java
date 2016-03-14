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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Main {

	public static int myWidth = 600;
	public static int myHeight = 800;
	public static JFrame frame;
	
	
	public static void main(String[] args) {

		HashMap userMap = new HashMap();
		userMap.put("", "");  // for testing only remove later.
		
//		ArrayList<String> itemsArrayList = new ArrayList<String>();
//		int count = 0;
//		for(int i = 0; i < 40; i++) {
//			count++;
//			
//			itemsArrayList.add("test" + count);
//		}
		
		Item one = new Item(0, "antique bottle", "steven", "jan 5 2016", "this is a bottle");
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(one);
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}
		
		
//		String itemsList[] = itemsArrayList.toArray(new String[itemsArrayList.size()]);
		
		
		//create Frame
		frame = new JFrame("AntiqueDB");
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(myWidth,myHeight));
		frame.setLocationRelativeTo(null);

		LogoPanel logoPanel = new LogoPanel();
		frame.add(logoPanel, BorderLayout.NORTH);
		createLoginPanel(userMap);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public static void stopEclipeFromRunning() {

	}

	public static void createLoginPanel(HashMap userMap) {

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
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrationGUI registration = new RegistrationGUI(userMap);

			}

		});

		JButton loginButton = new JButton("login");
		panel.add(loginButton);
		loginButton.setBounds(180, 80, 80, 25);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				String myName = userText.getText();
				String myPassword = passwordText.getText();


				if(userMap.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Wrong Username or Password");
				} else if(userMap.containsKey(myName)) {
					if(userMap.get(myName).equals(myPassword)) {
						Database dataPage = new Database(userMap);
					} else {
						JOptionPane.showMessageDialog(frame, "Wrong Username or Password");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong Username or Password");

				}

			}
		});


	}
}
































