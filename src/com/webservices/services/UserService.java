/**
 * 
 */
package com.webservices.services;

import com.webservices.dto.AccountRequest;
import com.webservices.modal.User;


public interface UserService {
	
	public User getUser(String emailOrPhone);
	public User storeUser(AccountRequest accountRequest,Integer userType);
	
	public User getUserByEmail(String email);
	
}
