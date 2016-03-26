package com.webservices.resources;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.webservices.dto.AccountRequest;
import com.webservices.dto.LoginResponse;
import com.webservices.dto.ServiceResponse;
import com.webservices.exception.GenericReponse;
import com.webservices.modal.User;
import com.webservices.modal.UserAccesstoken;
import com.webservices.modal.UserServiceMapping;
import com.webservices.services.EmailService;
import com.webservices.services.HelperService;
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
	
	@Autowired
	private HelperService helperService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private MessageSource messageSource; 
	/**
	 * This method used to validate email and password
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuData(@QueryParam("email") String email,@QueryParam("password") String password)  throws Exception {
		 User user = null;
		 GenericReponse response = new GenericReponse();
		 LoginResponse loginResponse = null;
		try{
			user =userService.getUser(email);
			
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
			userAccessToken.setUser(user);
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
			List<UserServiceMapping> userServiceMappings =  user.getUserServiceMappings();
			//Long services [] = new Long [userServiceMappings.size()];
			List<ServiceResponse> services = new ArrayList<ServiceResponse>();
			
			for (UserServiceMapping userServiceMapping : userServiceMappings) {
				services.add(new ServiceResponse(userServiceMapping.getService()));
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createAccount")
	public Response createAccount(AccountRequest accountRequest,@QueryParam("language") String language) throws Exception {
		GenericReponse response = new GenericReponse();		
		try
		{			
			Response checkResponse = helperService.doAccesstokenChecks(accountRequest.getAccessToken());
			if (checkResponse == null || checkResponse.getStatus() != Response.Status.OK.getStatusCode())
			{
				return checkResponse;
			}
			
			//check if email address is already in user
		if (userService.getUserByEmail(accountRequest.getEmail()) != null)
		{
			Status status = new Status(Status.EMAIL_IN_USE);
			response.setStatusObject(status);
			LOGGER.log(Level.INFO, status.toString());
			return Response.status(Response.Status.OK).entity(response).build();
		}
		
		int userType = -1;
		try
		{
			Integer userTypeInteger = new Integer(accountRequest.getUserType());
			userType = userTypeInteger.intValue();
		}
		catch (NumberFormatException e)
		{
			
			LOGGER.log(Level.INFO, Response.Status.INTERNAL_SERVER_ERROR.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		// server side input validation 
		//check privileges
		if (userType == 0)
		{
			
			Status status = new Status(Status.NO_PRIVILEGE);
			response.setStatusObject(status);
			LOGGER.log(Level.INFO, status.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		} 
		if(accountRequest.getServiceIds()==null || accountRequest.getServiceIds().length==0){
			Status status = new Status(Status.NO_SERVICE);
			response.setStatusObject(status);
			LOGGER.log(Level.INFO, status.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
							
		User user =userService.storeUser(accountRequest,userType);
		if(user!=null){
			emailService.sendMail(user.getEmail(), messageSource.getMessage("mail.subject",null,null), messageSource.getMessage("mail.createaccount",new Object[]{accountRequest.getPassword()},null));
			
		}
		return Response.status(Response.Status.OK).entity(user).build();		
		
	}catch (HibernateException e)
		{			
			Status status = new Status(Status.INVALID_EMAIL);
			response.setStatusObject(status);
			LOGGER.log(Level.INFO, status.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
	}
	
	

}
