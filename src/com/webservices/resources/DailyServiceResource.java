package com.webservices.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.webservices.custom.modal.DailyServiceList;
import com.webservices.exception.GenericReponse;
import com.webservices.modal.DailyService;
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
	public Response getMenuData(@HeaderParam("token") String token,@HeaderParam("serviceID") String serviceID,@HeaderParam("userId") String userId,DailyService dailyService)  throws Exception {
		 GenericReponse response = new GenericReponse();
		try{			
		System.out.println("DailyServiceResource.token()---"+token);
		System.out.println("DailyServiceResource.serviceID()---"+serviceID);
		System.out.println("DailyServiceResource.userId()---"+userId);		
		 Services services = new Services();
		 services.setServiceId(Long.parseLong(serviceID));		 
		 dailyService.setUserId(Integer.parseInt(userId));		
		/* dailyServiceId.setActive("Y");
		 dailyServiceId.setServiceId(1L);;
		 dailyServiceId.setItemDesc("test");
		 dailyServiceId.setType(1);*/
		
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
