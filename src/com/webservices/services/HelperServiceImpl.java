package com.webservices.services;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.webservices.exception.GenericReponse;
import com.webservices.modal.UserAccesstoken;
import com.webservices.repository.UserAccesstokenRepository;
import com.webservices.utils.Status;


/**
 * CmsHelperServiceImpl Class
 * @author om
 *
 */
@Service("helperService")
public class HelperServiceImpl implements HelperService {	
		
	
	/** The Constant logger. */
	private static Logger LOGGER = LogManager.getLogger(HelperServiceImpl.class);		
	
	@Autowired
	UserAccesstokenRepository userAccesstokenRepository;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	
	
	/**
	 * This helper method used to validate accesstoken 
	 * @param accesstoken String
	 */
	
	public Response doAccesstokenChecks( String accesstoken)
	{
		GenericReponse response = new GenericReponse();
		//check if accesstoken is valid
		UserAccesstoken accessToken = userAccesstokenRepository.getAccessTokenBytoken(accesstoken);
		if (accessToken == null || accessToken.getValidUntil().before(new Date(System.currentTimeMillis())))
		{
			Status status = new Status(Status.ACCESSTOKEN_INVALID);
			response.setStatusObject(status);
			LOGGER.info( status.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
		return Response.ok().build();
	}	
	
}
