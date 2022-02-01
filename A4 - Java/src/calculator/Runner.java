/**
 * @author Tomas Ruiters and Edwin Asselman.
 */
package calculator;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Runner {
	
	/**
	 * Initiate a new calculator instance.
	 * 
	 * @param args
	 * 
	 * @return void
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setVisible(true);
		frame.setSize(500, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		// Initiate a new controller instance.
		frame.add(new Controller());
	}

}
