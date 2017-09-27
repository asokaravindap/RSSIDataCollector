package com.rssi.datacol;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.rssi.datacol.db.*;

public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
    	Properties properties = new Properties();
    	
    	try {
			properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/service.properties"));
			
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
        if(!MySQLConnector.getInstance().isInitialized()){
            try {
            	MySQLConnector.getInstance().init(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    
}