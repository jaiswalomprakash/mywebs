package com.webservices.resources;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.webservices.custom.modal.LoginResponse;
import com.webservices.custom.modal.ServiceResponse;
import com.webservices.exception.GenericReponse;
import com.webservices.modal.UserAccesstoken;
import com.webservices.modal.UserServiceMapping;
import com.webservices.modal.Users;
import com.webservices.services.UserAccessTokenService;
import com.webservices.services.UserService;
import com.webservices.utils.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuResource.
 */
@Path("/userService")
public class UserResource {
	

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(UserResource.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAccessTokenService userAccessTokenService;
	/**
	 * Gets the menu data.
	 *
	 * @param menu_id the menu_id
	 * @param language the language
	 * @return the menu data
	 * @throws InboundException the inbound exception
	 */
	@GET
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuData(@QueryParam("email") String email,@QueryParam("password") String password)  throws Exception {
		 Users user = null;
		 GenericReponse response = new GenericReponse();
		 LoginResponse loginResponse = null;
		try{
			user =userService.login(email);
			
			if (user == null)
			{				
				Status status = new Status(Status.NO_USER);
				response.setStatusObject(status);
				LOGGER.log(Level.INFO, status.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
			}
			//check if user account is activated
			if (!user.getActive().equals("Y"))
			{
				
				Status status = new Status(Status.ACCOUNT_NOT_ACTIVATED);
				response.setStatusObject(status);
				LOGGER.log(Level.INFO, status.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
			}
			//check if passwords match
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if (!passwordEncryptor.checkPassword(password, user.getPassword()))
			{
				
				Status status = new Status(Status.NO_PASSWORD_MATCH);
				response.setStatusObject(status);
				LOGGER.log(Level.INFO, status.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
			}
			//generate accesstoken
			UUID accessToken = UUID.randomUUID();
			//store accesstoken
			UserAccesstoken userAccessToken = new UserAccesstoken();
			userAccessToken.setToken(accessToken.toString());
			userAccessToken.setUsers(user);
			int ttl = 24 * 60 * 60 * 1000;
			try
			{
				Integer ttlInteger = new Integer(24 * 60 * 60 * 1000);
				ttl = ttlInteger.intValue();
			}
			catch (NumberFormatException e)
			{
				LOGGER.log(Level.TRACE, e.getLocalizedMessage());
			}
			Date validUntil = new Date(System.currentTimeMillis() + ttl);
			userAccessToken.setValidUntil(validUntil);
			userAccessToken = userAccessTokenService.storeToken(userAccessToken);
			if(userAccessToken!=null){
				loginResponse = new LoginResponse(user);
				loginResponse.setToken(userAccessToken.getToken());
			}
			Set<UserServiceMapping> userServiceMappings =  user.getUserServiceMappings();
			//Long services [] = new Long [userServiceMappings.size()];
			List<ServiceResponse> services = new ArrayList<ServiceResponse>();
			
			for (UserServiceMapping userServiceMapping : userServiceMappings) {
				services.add(new ServiceResponse(userServiceMapping.getServices()));
			}
			
			loginResponse.setServices(services);
			//int p = 10/0;
			
		}
		catch (Exception arithmeticException) {
			//LOGGER.error("Exception in getMenuData API",arithmeticException);
			 throw new WebApplicationException(arithmeticException.getMessage());
		}
		return Response.ok(Response.Status.OK).header("content-type", MediaType.APPLICATION_JSON + ";charset=utf-8")
				.entity(loginResponse).build();
	}
	
	

}
