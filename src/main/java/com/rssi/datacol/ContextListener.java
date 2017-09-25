package com.rssi.datacol;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.rssi.datacol.beans.PropertyPack;
import com.rssi.datacol.db.*;

public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
    	
    	Properties properties = new Properties();
    	PropertyPack propertiesObj = new PropertyPack();
    	
    	try {
			properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/service.properties"));		    
			
			propertiesObj.setdbPath(properties.getProperty("DBPath"));
			propertiesObj.setuserName(properties.getProperty("UserName"));
			propertiesObj.setpassword(properties.getProperty("Password"));
			
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
        if(!MySQLConnector.getInstance().isInitialized()){
            try {
            	MySQLConnector.getInstance().init(propertiesObj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}