import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JComponent;

public class DrawingComponent extends JComponent implements ActionListener {
	
	private orbitingPoint orbiter = new orbitingPoint ("Sputnik", 250d, (double)85, -1.2,0d,0.5);
	private orbitingPoint orbiter2 = new orbitingPoint ("Ares", 245d, (double)99, -1.4,0d,0.5);
	private centerOfMass earth = new centerOfMass (250d,250d,5700000);
	private double gravConstant = (6.67 * Math.pow(10, -5));
	// DecimalFormat used to display velocity values to user
	private DecimalFormat df = new DecimalFormat("####.##");
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//create background canvas
		g2.setColor(Color.black);
		g2.fillRect(0,0, 800, 600);
		
		//draw information pane
		g2.setColor(Color.white);
		g2.fillRect(595, 5, 200, 90);
		g2.setColor(Color.black);
		g2.setFont(new Font(null, Font.BOLD, 25));
		String velocity1 = df.format(1000 * orbiter.getVelocity())+ " m/s";
		String velocity2 = df.format(1000 * orbiter2.getVelocity())+ " m/s";
		g2.drawString(velocity1, 605, 40);
		g2.drawString(velocity2, 605, 80);
		
		//draw centerOfMass earth
		int earthSize = 120;
		int earthDrawX = (int)earth.getX() - earthSize/2;
		int earthDrawY = (int)earth.getY() - earthSize/2;
		g2.setColor(Color.green);
		g2.fillOval(earthDrawX,earthDrawY,earthSize,earthSize);
		
		//draw orbitingPoint orbiter
		int orbiterSize = 10;
		int orbiterDrawX = (int)orbiter.getX() - orbiterSize/2; 
		int orbiterDrawY = (int)orbiter.getY() - orbiterSize/2;
		g2.setColor(Color.blue);
		g2.fillOval(orbiterDrawX, orbiterDrawY, orbiterSize, orbiterSize);
		
		int orbiter2Size = 10;
		int orbiter2DrawX = (int)orbiter2.getX() - orbiter2Size/2; 
		int orbiter2DrawY = (int)orbiter2.getY() - orbiter2Size/2;
		g2.setColor(Color.cyan);
		g2.fillOval(orbiter2DrawX, orbiter2DrawY, orbiter2Size, orbiter2Size);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//after each tick of the timer, run this event.
		
		orbiter.updatePositionAndAcceleration(earth.getMass(), gravConstant, earth.getX(), earth.getY());
		orbiter2.updatePositionAndAcceleration(earth.getMass(), gravConstant, earth.getX(), earth.getY());
		repaint();
		
	}
	
}
