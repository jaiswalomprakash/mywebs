package com.webservices.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.webservices.modal.User;
import com.webservices.repository.UsersRepository;

@Service("UserService")
public class UsersServiceImpl implements UserService {
	/** The Constant logger. */
	  private static Logger logger = LogManager.getLogger(UsersServiceImpl.class); // Example log4j2.
	
	/** The storeprofile repository. */
	@Autowired 
	private UsersRepository usersRepository;
	
	
	
	@Autowired
	private MessageSource messageSource;
	@Override
	public User login(String emailOrPhone) {
		return usersRepository.login(emailOrPhone);
	}

}
