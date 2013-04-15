package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *  Klassen MySQLSpeak innehåller alla databasoperationer som gör för spelet. 
 */
public class MySQLSpeak {
	private LinkedList<String> statistic = new LinkedList<String>();

	/**
	 *Skapar en databasuppkoppling till speldatabasen. Returnerar denna kopplingen. 
	 */
	public Connection createDatabaseConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Driver loaded");

		Connection connection = DriverManager.getConnection("jdbc:mysql://db-und.ida.liu.se/darqu896", "darqu896", "darqu8963bfd");
		return connection;
	}
	
	/**
	 * Funktionen undersöker om en specifik användare finns i databasen.
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public String checkUser(String username) throws ClassNotFoundException, SQLException{
		Connection connection = createDatabaseConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT username FROM user");
		while(resultSet.next()){

			if(resultSet.getString(1).equals(username)){
				
				System.out.println("Found username.");
				connection.close();
				
				return username;	
			}
		}
		connection.close();
		return null;
	}

	/**
	 * Funktionen undersöker om det går att logga in med det givna lösenordet och användarnamnet
	 * @param username
	 * @param password
	 * @return true eller false beroende på om inloggningen lyckades eller ej
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException{
		
		if(checkUser(username) == username){
			Connection connection = createDatabaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT password FROM user WHERE username =" +"'" + username + "'");
			
			
			
				
				while(resultSet.next()){
					if(resultSet.getString(1).equals(password)){
						System.out.println("Password correct");
						connection.close();
						return true;	
					}
				}
				
				System.out.println("Wrong password");
				connection.close();
				return false;
			
		}
		
			System.out.println("No such username");
			return false;
	}
	
	/**
	 * Funktionen registerUser lägger till en användare om det inte existerar en redan.
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public boolean registerUser(String username, String password) throws ClassNotFoundException, SQLException{
		if(checkUser(username) == null){
			Connection connection = createDatabaseConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO user VALUES(" + "'" + username + "'" + ",'" + password + "'," + "0, 0, 0)");
			System.out.println("Success in registration");
			return true;
		}
		
		System.out.println("Existerar redan användare med " + username + " som användarnamn.");
		return false;
	}
	
	
	/**
	 * Funktionen fetchStatistics hämtar statistik för en specifik användare. wins, loses och ties sparas i en lista.
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public LinkedList<String> fetchStatistics(String username) throws ClassNotFoundException, SQLException{
		
		
		Connection connection = createDatabaseConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT wins, loses, ties FROM user WHERE username =" +"'" + username + "'");
		
		while(resultSet.next()){
			
				statistic.add(resultSet.getString(1));
				statistic.add(resultSet.getString(2));
				statistic.add(resultSet.getString(3));
		}
		connection.close();
		return statistic;
		
	}
	
	
}

