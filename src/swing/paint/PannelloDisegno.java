package swing.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PannelloDisegno extends JPanel {

	private static final long serialVersionUID = 4582683071516221594L;

	private Image image;
	private double degree;
	
	public PannelloDisegno()
	{
		try {
			image= ImageIO.read(new File("rick-astley.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		
		
		AffineTransform identity = new AffineTransform();
		AffineTransform trans = new AffineTransform();
		trans.setTransform(identity);
		trans.translate(400, 226);
		trans.rotate( Math.toRadians(degree) );
		trans.translate(-400, -226);
		g2d.drawImage(image, trans, this);
		g2d.setColor(Color.RED);
		// creates a solid stroke with line width is 2
		Stroke stroke = new BasicStroke(2f);
		g2d.setStroke(stroke);
		g2d.drawLine(120, 50, 360, 50);
		 
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(4f));
		g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
		 
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(6f));
		g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
	
		
		
		}
	public void refresh() {
		degree+=0.5;
		this.repaint();
		
	}
}
