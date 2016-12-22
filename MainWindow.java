import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

	static JFrame window;
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		window = new JFrame("OrbitingPoint");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		JPanel buttonPanel = new JPanel();
		  window.add(buttonPanel,BorderLayout.PAGE_START);
		  JButton button = new JButton("Start/Stop");
		  buttonPanel.add(button);
		  Action1 startPress = new Action1();
		  button.addActionListener (startPress);
		  
		  JButton button2 = new JButton("Create new Orbiter");
		  buttonPanel.add(button2);
		  Action2 newPress = new Action2();
		  button2.addActionListener (newPress);
		
		DrawingComponent dc = new DrawingComponent();
		window.add(dc, BorderLayout.CENTER);
		windowHandler.giveWindow(dc);
		startPress.giveWindow(dc);
		
		
	}

	static class windowHandler {
		static DrawingComponent dc;
		
		public static void giveWindow (DrawingComponent D){
			dc = D;
		}
		public static DrawingComponent getWindow() {
			return dc;
		}
	}
	
	static class Action1 implements ActionListener {
		DrawingComponent dc;
		Boolean clicked = false;
		Timer t;
		
		public void giveWindow (DrawingComponent D) {
			dc = D;
		}
		public void actionPerformed (ActionEvent e) {     
			if (!clicked) {  
				t = new Timer(50, dc);
				t.start();
				this.clicked = true;
			} else {
				t.stop();
				this.clicked = false;
				}
			
		  }
		}
	
	static class Action2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			inputDialog input = new inputDialog(window, "New Orbiter Input");
		}
	}
}
