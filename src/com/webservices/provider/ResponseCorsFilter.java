package com.webservices.provider;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
 
/**
 * The Class ResponseCorsFilter.
 */
@Provider
public class ResponseCorsFilter implements ContainerResponseFilter {
    
  	/* (non-Javadoc)
	   * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	   */
	  @Override
	public void filter(ContainerRequestContext creq, ContainerResponseContext cres) throws IOException {
		    cres.getHeaders().add("Access-Control-Allow-Origin", "*");
	        cres.getHeaders().add("Access-Control-Allow-Headers", "token,serviceID,userId, X-Requested-With, origin, content-type, accept, authorization, X-csrftoken");
	        cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
	        cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	        //cres.getHeaders().add("Access-Control-Allow-Headers", "x-auth-token, x-requested-with");
	        
	}
}