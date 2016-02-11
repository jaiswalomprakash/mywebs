package com.webservices.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.webservices.modal.UserAccesstoken;
import com.webservices.modal.Users;
import com.webservices.repository.UserAccesstokenRepository;
import com.webservices.repository.UsersRepository;

@Service("UserAccessTokenServcieImpl")
public class UserAccessTokenServcieImpl implements UserAccessTokenService {
	/** The Constant logger. */
	  private static Logger logger = LogManager.getLogger(UserAccessTokenServcieImpl.class); // Example log4j2.
	
	/** The storeprofile repository. */
	@Autowired 
	private UserAccesstokenRepository userAccesstokenRepository;
	
	@Autowired
	private MessageSource messageSource;
	@Override
	public UserAccesstoken storeToken(UserAccesstoken userAccesstoken) {
		return userAccesstokenRepository.save(userAccesstoken);
	}
	
	
}
