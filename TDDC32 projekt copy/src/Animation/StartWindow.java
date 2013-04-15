package Animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.MySQLSpeak;


/**
 * Klass som körs när programmet startas, ger användaren 
 * möglighet att antingen logga in eller registrera sig
 * @author Hagström
 *
 */

public class StartWindow {

	static JFrame frame;
	static JPanel informationPanel;
	static JPanel logInArea;
	static JPanel registerArea;
	static MySQLSpeak databaseConnection;
	
	public StartWindow(MySQLSpeak databaseConnection){
		this.databaseConnection = databaseConnection;
		frame = new JFrame("FrågeKampen");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.blue);

		createPanel(frame);
		informationArea(informationPanel);
		frame.setVisible(true);
	}

	/**
	 * Lägger till funktionalitet i informationPanel
	 * @param informationPanel - den JPanel som funtionaliteten läggs till
	 */
	public static void informationArea(JPanel informationPanel){

		//skapar en JPanel där användaren ges möjlighet att logga in
		logInArea = new JPanel();
		logInArea.setLayout(new BorderLayout());
		

		JButton button = new JButton("Logga in");		
		button.setBackground(Color.BLUE);
		logInArea.add(button, BorderLayout.SOUTH);

		final JTextField userName = new JTextField("UserID");
		logInArea.add(userName, BorderLayout.NORTH);

		final JTextField passWord = new JTextField("PassWord");
		logInArea.add(passWord, BorderLayout.CENTER);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(userName.getText());		
				System.out.println(passWord.getText());
				String check = userName.getText();
				
				
				try {
					if(
						databaseConnection.loginUser(userName.getText(), passWord.getText())
					){
						frame.dispose();
						GameWindow gameWindow = new GameWindow();
						
						
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});

		//samma som tidigare faast för registrering
		registerArea = new JPanel();
		registerArea.setLayout(new BorderLayout());		

		JButton button2= new JButton("Registrera dig");		
		button2.setBackground(Color.cyan);
		registerArea.add(button2, BorderLayout.SOUTH);

		final JTextField newUserName = new JTextField("Your UserID?");		
		registerArea.add(newUserName, BorderLayout.NORTH);

		final JTextField newPassWord = new JTextField("Your Password?");
		registerArea.add(newPassWord, BorderLayout.CENTER);

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					databaseConnection.registerUser(newUserName.getText(), newPassWord.getText());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(newUserName.getText());
				System.out.println(newPassWord.getText());
				if(true){
					//frame.dispose();
				}
			}});


		//lägger till ovan skapade JPanels till informationPanel
		informationPanel.add(logInArea);
		informationPanel.add(registerArea);

	}


	/**
	 * Metod som skapar en JPanel, är den del som interagerar med användare
	 * @param frame
	 */

	public static void createPanel(JFrame frame){		
		informationPanel = new JPanel();
		frame.add(informationPanel, BorderLayout.SOUTH);
	}


}






