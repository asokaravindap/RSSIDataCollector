package com.rssi.datacol.impl;

import com.rssi.datacol.DataCollector;
import com.rssi.datacol.beans.AccessPoint;
import com.rssi.datacol.db.MySQLConnector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataCollectorImpl implements DataCollector{
	
	private String outputFile;

	public int storeData(List<AccessPoint> aps) {
		
		String timestamp = String.valueOf(System.currentTimeMillis());
		String data = this.arrayToString(aps); 
		
		if(MySQLConnector.getInstance().isInitialized()){
			
			Connection connection = MySQLConnector.getInstance().getConnection();	
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO temp (timestamp,scan) VALUES ('" + timestamp + "','" + data + "')");
				
			} catch (SQLException e) {
				e.printStackTrace();  
			}
		}
		
		this.appendToFile(outputFile, timestamp + ";" + data + "\n");    
    		
		return 0; 
	}

	private String arrayToString(List<AccessPoint> aps){
		
		String combStr = "";
		
		for(AccessPoint ap : aps){
			
			combStr = combStr + ap.getMacAddress() + "," + ap.getRssi() + "," + ap.getFrequency() + 
					"," + ap.getQuality() + ";"; 
		}
		
	    if(combStr.length() > 0){
	    	combStr = combStr.substring(0, combStr.length() - 1);
	    }
		
		return combStr;
	}
	
	private void appendToFile(String filePath, String data){
		
		BufferedWriter buffWriter = null;
		FileWriter fileWriter = null;

		try {
			
			File opFile = new File(filePath);

			if (!opFile.exists()) {
				opFile.createNewFile();
			}

			fileWriter = new FileWriter(opFile.getAbsoluteFile(), true);
			buffWriter = new BufferedWriter(fileWriter);

			buffWriter.write(data);

		} catch (IOException e) {
			  e.printStackTrace();
			  
		} finally {
			try {
			  if (buffWriter != null)
				  buffWriter.close();

			  if (fileWriter != null)
				  fileWriter.close();

			} catch (IOException ex) {
				  ex.printStackTrace();
			}
		}
	}
	
	public int getStoredDataCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setDate(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
}
