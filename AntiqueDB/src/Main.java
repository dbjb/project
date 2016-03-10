import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("frametest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
//		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(600,800));
		frame.setLocationRelativeTo(null);
		frame.pack();

		frame.setVisible(true);
		
		
		
		//		System.out.println("hello");
	}

}
