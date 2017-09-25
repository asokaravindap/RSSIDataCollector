package com.rssi.datacol.impl;

import com.rssi.datacol.DataCollector;
import com.rssi.datacol.beans.AccessPoint;
import com.rssi.datacol.db.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DataCollectorImpl implements DataCollector{

	//public int storeData(AccessPoint[] aps) {
	public int storeData() {	
		
		String timestamp = "1234";
		String str = "mac1rssitest";
		
		if(MySQLConnector.getInstance().isInitialized()){
			
			Connection connection = MySQLConnector.getInstance().getConnection();	
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO temp (timestamp,scan) VALUES ('" + timestamp + "','" + str + "')");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		// do a array to string conversion when storing the data into db and the text..
		
		// store the data in a text file initially and then consider hibernate + MySQL
		return 55;
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
