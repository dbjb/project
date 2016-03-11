import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JTable;
import javax.swing.JTextField;

public class Database {
	
	public static int myWidth = 600;
	public static int myHeight = 800;
	public static JFrame frame;
	public static int tableRowNum = 10;

	public Database() {
		//create Frame
		frame = new JFrame("AntiqueDB");
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(myWidth,myHeight));
		frame.setLocationRelativeTo(null);

		createLogoPanel();
		MiddlePanel();
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void MiddlePanel() {
		//create middle Panel
		JPanel panel =  new JPanel(new GridLayout(2, 1));
		
		//create Menu Buttons
		JPanel menuPanel = new JPanel();
		JButton print = new JButton("Print");
		menuPanel.add(print);
		JButton update = new JButton("Update");
		menuPanel.add(update);
		JButton add = new JButton("Add");
		menuPanel.add(add);
		JButton delete = new JButton("Delete");
		menuPanel.add(delete);
		JButton filter = new JButton("Filter");
		menuPanel.add(filter);
		JButton export = new JButton("Export");
		menuPanel.add(export);
		
		panel.add(menuPanel); //add menuPanel to middle panel
		createTablePanel(panel);
		frame.add(panel, BorderLayout.WEST); //add middle panel to JFrame
	}
	/**create panel to store table and added it to the middlePanel
	 * @param panel
	 */
	public static void createTablePanel(JPanel panel) {
		JPanel tablePanel = new JPanel(new GridLayout(2,2));
		
		JLabel itemList = new JLabel("Item List");
		tablePanel.add(itemList);
		
		JLabel selectedItems = new JLabel("Selected Items");
		tablePanel.add(selectedItems);
		
//		//create list of table
//		String[] columnNames = {"Item ID", "Name", "Category", "Quantity", "View Count",
//				"Item Cost", "Selling Price", "Condition", "Description"};
//		Object[][] data = {};
//		JTable table = new JTable(data, columnNames);
//		//tablePanel.add(table);
		
		panel.add(tablePanel);
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
































