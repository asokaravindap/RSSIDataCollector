package com.rssi.datacol.impl;

import com.rssi.datacol.DataCollector;
import com.rssi.datacol.beans.AccessPoint;
import com.rssi.datacol.db.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DataCollectorImpl implements DataCollector{

	public int storeData(AccessPoint[] aps) {
		
		if(MySQLConnector.getInstance().isInitialized()){
			
			Connection connection = MySQLConnector.getInstance().getConnection();	
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate("INSERT...");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// store the data in a text file initially and then consider hibernate + MySQL
		return 0;
	}

	public int getStoredDataCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setDate(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

}
