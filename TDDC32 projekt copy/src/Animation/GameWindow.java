package Animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GameWindow extends JFrame {
	
	JFrame gameWindow;
	JPanel buttonPanel;
	JPanel drawingArea;

	
	public GameWindow(){
		
		gameWindow = new JFrame("FrågeKampen // GameTime");
		gameWindow.setSize(800, 400);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		gameWindow.setLayout(new BorderLayout());
		
		buttonPanel(gameWindow);
		drawingArea(gameWindow);
		gameWindow.setVisible(true);
		}
	
	
	public void buttonPanel(JFrame gameWindow){
		
		buttonPanel = new JPanel();

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		buttonPanel.add(Box.createVerticalStrut(10));
		//buttonPanel.add(Box.createHorizontalStrut(20));
		
		
		
		JButton[] buttonList = buttons();
		
		for (int i = 0; i < buttonList.length; i++){			
			buttonPanel.add(buttonList[i]);		
		}		
		gameWindow.add(buttonPanel, BorderLayout.WEST);
		
	}
	
	public  JButton[] buttons(){
		
		JButton buttons[] = new JButton[5];		
		String buttonText[] = {"Nytt Spel", "Pågående Spel", "Statistik", "Om", "Hjälp" };
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(buttonText[i]);
			//buttons[i].add(Box.createHorizontalStrut(10));
			
			if (buttons[i].getText() == "Nytt Spel"){
			
				
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Nytt Spel");
						
					}
				});
			}
			
			else if (buttons[i].getText() == "Pågående Spel"){
				
				
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Pågående Spel");
						
					}
				});				
			}
			
			else if (buttons[i].getText() == "Statistik"){
		
				
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Statistik");
						
					}
				});
			}
			
			else if (buttons[i].getText() == "Om"){
				
				
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Om");
						
					}
				});
			}
			
			else if (buttons[i].getText() == "Hjälp"){
		
				
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println("Statistik");
						
					}
				});
			}
		
		
			
		}
		return buttons;
	}

	
	
	public void drawingArea(JFrame gameWindow){
		System.out.println("hej");
		
		drawingArea = new JPanel();
		
		JTextArea infoArea = new JTextArea();
		infoArea.setBackground(Color.GREEN);
		
		infoArea.setText("hej");
		
		drawingArea.add(infoArea);
		
		gameWindow.add(drawingArea, BorderLayout.CENTER);
		
		
		
		
	}
	
	

}
