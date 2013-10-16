package database;
import java.sql.*;

public class SimpleJdbc {

	/**
	 * @param args
	 * New branch
	 * 
	 * Edit branch woho
	 * nsadjsn
	 * not equal
	 */
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://db-und.ida.liu.se/darqu896", "darqu896", "darqu8963bfd");
		System.out.println("Database connection");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT id,name,state FROM jbcity LIMIT 2,4");
		while(resultSet.next()){
			System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2)+ "   " + resultSet.getString(3));
		}
		connection.close();
			
		

	}

}
