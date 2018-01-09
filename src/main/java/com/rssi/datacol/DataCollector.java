package com.rssi.datacol;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rssi.datacol.beans.AccessPoint;

@Path("/datacollector/")
public interface DataCollector {

	@POST
	@Path("/storeData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean storeData(List<AccessPoint> aps);
	
	@GET
	@Path("/getStoredDataCount")
	public int getStoredDataCount();
	
	@POST
	@Path("/setOrbFlag")
	public boolean setOrbFlag(boolean orbFlag);
	
	@POST
	@Path("/setDate")
	public int setDate(String date);
}
