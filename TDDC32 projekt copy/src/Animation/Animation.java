package Animation;

import database.MySQLSpeak;

public class Animation {
	
	
	/** Startar programmet och startar en instans av StartWindow
	 * @param args
	 */
	public static void main(String[] args) {
		MySQLSpeak databaseConnection = new MySQLSpeak();
		StartWindow start = new StartWindow(databaseConnection);
		
		

	}
}



