package sait.mms.drivers;

import java.sql.ResultSet;
import java.sql.SQLException;

import sait.mms.contracts.DatabaseDriver;

public class MariaDBDriver implements DatabaseDriver {

	@Override
	public void connect() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet get(String query) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String query) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void disconnect() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
