package lecture10;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OptionPaneIcons {

	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "Hello, World!");
		System.out.println(System.getProperty("user.dir"));
		JOptionPane.showMessageDialog(
				 null, 
				 "Hello, World!",
				 "Message",
				 JOptionPane.INFORMATION_MESSAGE,
				 new ImageIcon("resources/ab.gif"));
	}

}
