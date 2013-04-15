package Animation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();

	}

	public static void test(){
		JFrame hej = new JFrame();
		hej.setDefaultCloseOperation(hej.EXIT_ON_CLOSE);
		hej.setSize(300, 300);

		JPanel yellowLabel = new JPanel();
		yellowLabel.setOpaque(true);
		yellowLabel.setBackground(Color.CYAN);
		//yellowLabel.setPreferredSize(new Dimension(200, 180));
		
		JButton knapp = new JButton("knapp");
		yellowLabel.add(knapp);
		
		
		JLabel bajs = new JLabel();
		
		JButton knapp2 = new JButton("knapp");
		bajs.add(knapp2);
		
		
		
		
		yellowLabel.add(bajs);
		
		hej.getContentPane().add(yellowLabel);

		
		
		hej.pack();
		hej.setVisible(true);



	}

}
