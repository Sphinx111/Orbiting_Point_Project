import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.*;

public class MainWindow {
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		JFrame window = new JFrame("OrbitingPoint");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		DrawingComponent dc = new DrawingComponent();
		window.add(dc);
		
		Timer t = new Timer(50, dc);
		t.start();
		
	}

}
