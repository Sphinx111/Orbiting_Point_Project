
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class inputDialog extends JDialog implements ActionListener, PropertyChangeListener {

	private String name;
	private double x_coord;
	private double y_coord;
	private double x_velocity;
	private double y_velocity;
	private double mass;
	

    /** Creates the reusable dialog. */
    public inputDialog(JFrame aFrame, String title) {
        super(aFrame, title);

        //Get orbiter's name from user
        name = JOptionPane.showInputDialog("Please name your orbiter");
        
        //Get orbiter's location from user
        String parseXY = JOptionPane.showInputDialog("Please give X,Y coordinates separated by a comma");
        String[] splitParseXY = parseXY.split("\\,");
        x_coord = Double.parseDouble(splitParseXY[0]);
        y_coord = Double.parseDouble(splitParseXY[1]);
        
        //Get orbiter's velocity from user
        String velocityXY = JOptionPane.showInputDialog("Pleae give [X,Y] velocity of orbiter separated by comma");
        String[] splitVelocityXY = velocityXY.split(",");
        x_velocity = Double.parseDouble(splitVelocityXY[0]);
        y_velocity = Double.parseDouble(splitVelocityXY[1]);
        
        //Get orbiter's mass from user
        String massString = JOptionPane.showInputDialog("please enter mass of orbiter");
        mass = Double.parseDouble(massString);
        
        orbitingPoint o = new orbitingPoint(name, x_coord, y_coord, x_velocity, y_velocity, mass);
        DrawingComponent dc = MainWindow.windowHandler.getWindow();
        dc.addOrbitingPoint(o);        

        //Handle window closing correctly.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Register an event handler that reacts to option pane state changes.
     


    }


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
