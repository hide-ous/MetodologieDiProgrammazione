package lecture16.swing101;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Components101 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JButton helloButton = new JButton("Say Hello");
		JButton goodbyeButton = new JButton("Say Goodbye");
		
		final int FIELD_WIDTH = 20;
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("Click a button!");
		
		helloButton.addActionListener(event ->
		   textField.setText("Hello, World!"));
		goodbyeButton.addActionListener(event ->
		   textField.setText("Goodbye, World!"));
		
		frame.setLayout(new FlowLayout());
		
		frame.add(helloButton);
		frame.add(goodbyeButton);
		frame.add(textField);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
