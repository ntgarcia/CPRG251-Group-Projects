package sait.mms.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sait.mms.contracts.DatabaseDriver;

public class MariaDBDriver implements DatabaseDriver {
	
	// Values needed to get a connection to your DB.
	private static final String SERVER = "localhost";
	private static final int       PORT = 3306;
	private static final String DATABASE = "cprg251";
	private static final String USERNAME = "cprg251";
	private static final String PASSWORD = "password";
	
	final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", 
               SERVER, PORT, DATABASE, USERNAME, PASSWORD);
	
	Connection conn;
	
	public MariaDBDriver() {
	}
	
	@Override
	public void connect() throws SQLException {
		
		try{
	         // Create a connection to the database.
	         conn = DriverManager.getConnection(DB_URL);
	         
	      }
	      catch(SQLException ex){
	         System.out.println("ERROR: " + ex.getMessage());
	      }
	}

	@Override
	public ResultSet get(String query) throws SQLException {
		int durationSum = 0;
		connect();
		
		// Create a Statement object.
		Statement stmt = conn.createStatement();
		
		// Send the statement to the DBMS.
		ResultSet result = stmt.executeQuery(query);
		
		// Display the contents of the result set.
		
		System.out.println("");
		System.out.println("Movie List");
		System.out.println("Duration    Year  Title");
		while (result.next()) {
			durationSum += result.getInt("Duration");
			System.out.printf("%-11d %-5s %s\n",
			result.getInt("Duration"),
			(result.getString("Year")).substring(0, 4),
			result.getString("Title"));
		}
		System.out.println("");
		System.out.println("Total duration: " + durationSum + " minutes\n");
		
		return result;
	}

	@Override
	public int update(String query) throws SQLException {
		connect();
		
		// Create a Statement object.
		Statement stmt = conn.createStatement();
				
		// Send the statement to the DBMS.
		int rows = stmt.executeUpdate(query);
		
		return rows;
		
	}

	@Override
	public void disconnect() throws SQLException {
		conn.close();
		
	}

}
