package com.rssi.datacol;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rssi.datacol.beans.AccessPoint;


@Path("/datacollector/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DataCollector {

	@POST
	@Path("/storeData")
	public int storeData(AccessPoint[] person);
	
	@GET
	@Path("/getStoredDataCount")
	public int getStoredDataCount();
	
	@POST
	@Path("/setDate")
	public int setDate(String date);
}
