package lecture16.swing.paint;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class Finestra extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Finestra()
	{
		super("Tutorial di Disegno in JPanel");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		PannelloDisegno myPanel = new PannelloDisegno();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);
		pack();

		setBounds(0, 0, 800, 600);
		int delay = 10; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  myPanel.refresh();
		      }
		  };
		  new Timer(delay, taskPerformer).start();
	
	}
}
