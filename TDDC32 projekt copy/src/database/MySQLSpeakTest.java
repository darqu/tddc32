package database;

import java.sql.SQLException;

public class MySQLSpeakTest {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySQLSpeak test = new MySQLSpeak();
		System.out.println(test.fetchStatistics("Bajs"));
	}

}
