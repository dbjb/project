import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationGUI extends JFrame{

	public RegistrationGUI (HashMap userMap) {
		super();
		createWindow(userMap);
	}

	public void createWindow(HashMap theUserMap) {
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 500));
		this.setTitle("Registration Page");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.CENTER);
		
		LogoPanel logoPanel = new LogoPanel();
		this.add(logoPanel, BorderLayout.NORTH);
		
		JLabel userlabel = new JLabel("Create Username");
		panel.add(userlabel, BorderLayout.CENTER);
		
		JTextField username = new JTextField(20);
		panel.add(username);
		
		JLabel passwordlabel = new JLabel("Create Password");
		panel.add(passwordlabel);
		
		JTextField password = new JTextField(20);
		panel.add(password, BorderLayout.EAST);
		
		JButton registerButton = new JButton("Register");
		panel.add(registerButton);
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String textfieldName = username.getText();
				String textfieldPassword = password.getText();
				if(theUserMap.containsKey(textfieldName) || textfieldName.isEmpty() || textfieldPassword.isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Username already exists or fields are empty!");
				} else {
					theUserMap.put(textfieldName, textfieldPassword);
				}
				System.out.println(theUserMap.entrySet());
			}
			
		});
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});

	}
}
