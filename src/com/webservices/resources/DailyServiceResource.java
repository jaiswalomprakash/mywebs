package com.webservices.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.Days360;
import org.springframework.beans.factory.annotation.Autowired;

import com.webservices.custom.modal.DailyServiceList;
import com.webservices.exception.GenericReponse;
import com.webservices.modal.DailyService;
import com.webservices.modal.DailyServiceId;
import com.webservices.modal.Services;
import com.webservices.services.DailyBasisService;

@Path("/dailyService")
public class DailyServiceResource {
	
	public static  Logger LOGGER = LogManager.getLogger(DailyServiceResource.class);
	
	@Autowired
	private DailyBasisService dailyBasisService;
	
	@POST
	@Path("/storeDailyRecords")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuData(DailyServiceId dailyServiceId)  throws Exception {
		 GenericReponse response = new GenericReponse();
		try{
			
		
		
		 Services services = new Services();
		 services.setServiceId(1L);		 
		 DailyService dailyService = new DailyService();
		
		/* dailyServiceId.setActive("Y");
		 dailyServiceId.setServiceId(1L);;
		 dailyServiceId.setItemDesc("test");
		 dailyServiceId.setType(1);*/
		 dailyService.setId(dailyServiceId);
		 dailyService.setServices(services);
		
		 dailyBasisService.storeDailyBasisService(dailyService);
		}catch(Exception ex){
			 throw new WebApplicationException(ex.getMessage());
		}
			
		return Response.status(Response.Status.OK).entity(response).build();
		
	}
	
	
	@GET
	@Path("/getDailyRecords")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuData()  throws Exception {
		 GenericReponse response = new GenericReponse();
		 DailyServiceList dailyServiceList =new DailyServiceList();
		 List<DailyService> list ;
		try{		
			list = dailyBasisService.getDailyBasisService();
			dailyServiceList.setDailyServices(list);
		 
		}catch(Exception ex){
			 throw new WebApplicationException(ex.getMessage());
		}
			
		return Response.status(Response.Status.OK).entity(dailyServiceList).build();
		
	}
	
	
	
	
	
	

}
