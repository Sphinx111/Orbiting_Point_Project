import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawingComponent extends JComponent implements ActionListener {
	
	private ArrayList<orbitingPoint> orbiterList = new ArrayList<>(0); 
	
	
	private centerOfMass earth = new centerOfMass (250d,250d,5700000);
	private double gravConstant = (6.67 * Math.pow(10, -5));
	// DecimalFormat used to display velocity values to user
	private DecimalFormat df = new DecimalFormat("####.##");
	
	public void addOrbitingPoint (orbitingPoint o) {
		this.orbiterList.add(o);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//create background canvas
		g2.setColor(Color.black);
		g2.fillRect(0,50, 800, 550);
		
		//draw information pane
		g2.setColor(Color.white);
		g2.fillRect(595, 5, 200, 90);
		g2.setColor(Color.black);
		g2.setFont(new Font(null, Font.BOLD, 25));
		for (int i = 0; i < orbiterList.size(); i++) {
		String velocity = df.format(1000 * orbiterList.get(i).getVelocity())+ " m/s";
		g2.drawString(velocity, 605, ((i+2)*20));
		}
		
		//draw centerOfMass earth
		int earthSize = 120;
		int earthDrawX = (int)earth.getX() - earthSize/2;
		int earthDrawY = (int)earth.getY() - earthSize/2;
		g2.setColor(Color.green);
		g2.fillOval(earthDrawX,earthDrawY,earthSize,earthSize);
		
		//draw orbitingPoint orbiter
		for (int i = 0; i < orbiterList.size(); i++) {
			orbitingPoint current = orbiterList.get(i);
			int orbiterSize = 10;
			int orbiterDrawX = (int)current.getX() - orbiterSize/2; 
			int orbiterDrawY = (int)current.getY() - orbiterSize/2;
			g2.setColor(Color.blue);
			g2.fillOval(orbiterDrawX, orbiterDrawY, orbiterSize, orbiterSize);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//after each tick of the timer, run this event.
		for (int i = 0; i < orbiterList.size(); i++) {
			orbiterList.get(i).updatePositionAndAcceleration(earth.getMass(), gravConstant, earth.getX(), earth.getY());
		}
		repaint();
		
	}
	
}
