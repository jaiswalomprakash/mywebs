package com.webservices.resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.webservices.dto.DailyServiceList;
import com.webservices.exception.GenericReponse;
import com.webservices.modal.DailyService;
import com.webservices.modal.Service;
import com.webservices.modal.User;
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
		//System.out.println("DailyServiceResource.token()---"+token);
		//System.out.println("DailyServiceResource.serviceID()---"+serviceID);
		System.out.println("DailyServiceResource.userId()---"+userId);		
		Service service = new Service();
		 service.setServiceId(Integer.parseInt(serviceID));
		 User user = new User();
		 user.setUserId(Integer.parseInt(userId));
		 dailyService.setUser(user);
		/* dailyServiceId.setActive("Y");
		 dailyServiceId.setServiceId(1L);;
		 dailyServiceId.setItemDesc("test");
		 dailyServiceId.setType(1);*/
		
		 dailyService.setService(service);
		
		 dailyBasisService.storeDailyBasisService(dailyService);
		}catch(Exception ex){
			 throw new WebApplicationException(ex.getMessage());
		}
			
		return Response.status(Response.Status.OK).entity(response).build();
		
	}
	
	
	@GET
	@Path("/getDailyRecords")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDailyRecords(@HeaderParam("serviceID") String serviceID)  throws Exception {
	//	System.out.println("DailyServiceResource.serviceID()---"+serviceID);
		 GenericReponse response = new GenericReponse();
		 Calendar calendar = Calendar.getInstance();  
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			Date startDate = calendar.getTime();  
			calendar.add(Calendar.MONTH, 1);  
			calendar.set(Calendar.DAY_OF_MONTH, 1);  
			calendar.add(Calendar.DATE, -1);  

			Date endDate = calendar.getTime();  

			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  
			//System.out.println("Today            : " + sdf.format(startDate));  
		//	System.out.println("Last Day of Month: " + sdf.format(endDate));
		 DailyServiceList dailyServiceList =new DailyServiceList();
		 List<DailyService> list ;
		try{		
			list = dailyBasisService.findByDatesBetween(startDate, endDate, Integer.parseInt(serviceID));
			dailyServiceList.setDailyServices(list);
		 
		}catch(Exception ex){
			 throw new WebApplicationException(ex.getMessage());
		}
			
		return Response.status(Response.Status.OK).entity(dailyServiceList).build();
		
	}
	
	@GET
	@Path("/getDailyServiceById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDailyServiceById(@HeaderParam("serviceID") String serviceID,@QueryParam("service_id") Integer service_id)  throws Exception {
		//System.out.println("DailyServiceResource.serviceID()---"+service_id);
		 GenericReponse response = new GenericReponse();
		 
		 DailyService DailyService =new DailyService();
		 List<DailyService> list ;
		try{		
			DailyService = dailyBasisService.getDailyBasisServiceById(service_id);
			
		 
		}catch(Exception ex){
			 throw new WebApplicationException(ex.getMessage());
		}
			
		return Response.status(Response.Status.OK).entity(DailyService).build();
		
	}
	
	public static void main(String[] args) {
		  

		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date firstDayOfMonth = calendar.getTime();  
		calendar.add(Calendar.MONTH, 1);  
		calendar.set(Calendar.DAY_OF_MONTH, 1);  
		calendar.add(Calendar.DATE, -1);  

		Date lastDayOfMonth = calendar.getTime();  

		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  
		System.out.println("Today            : " + sdf.format(firstDayOfMonth));  
		System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
	}
	
	
	
	
	

}
