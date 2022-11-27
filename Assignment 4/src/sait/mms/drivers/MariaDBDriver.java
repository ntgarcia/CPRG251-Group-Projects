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
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		// Create a Statement object.
		Statement stmt = conn.createStatement();
		
		// Send the statement to the DBMS.
		ResultSet result = stmt.executeQuery(query);
		
		return result;
	}

	@Override
	public int update(String query) throws SQLException {
		
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
