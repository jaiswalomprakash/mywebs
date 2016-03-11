package com.webservices.services;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.webservices.dto.AccountRequest;
import com.webservices.modal.User;
import com.webservices.modal.UserRoleMapping;
import com.webservices.modal.UserRoleMappingPK;
import com.webservices.modal.UserServiceMapping;
import com.webservices.modal.UserServiceMappingPK;
import com.webservices.repository.UserRoleMappingRepository;
import com.webservices.repository.UserServiceMappingRepository;
import com.webservices.repository.UsersRepository;

@Service("UserService")
public class UsersServiceImpl implements UserService {
	/** The Constant logger. */
	  private static Logger logger = LogManager.getLogger(UsersServiceImpl.class); // Example log4j2.
	
	/** The storeprofile repository. */
	@Autowired 
	private UsersRepository usersRepository;
	
	@Autowired 
	private UserRoleMappingRepository userRoleMappingRepository;
	
	@Autowired
	private UserServiceMappingRepository userServiceMappingRepository;
	
	@Autowired
	private MessageSource messageSource;
	@Override
	public User getUser(String emailOrPhone) {
		return usersRepository.login(emailOrPhone);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return usersRepository.getuserByEmail(email);
	}
	@Override
	public User storeUser(AccountRequest accountRequest,Integer userType) {
		User user =null;
			try {
				// store new user
				// encrypt password
				StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
				String encryptedPassword = passwordEncryptor.encryptPassword(accountRequest.getPassword()!=null?accountRequest.getPassword():accountRequest.getEmail());
				user = new User();
				user.setActive("Y");
				user.setFirstName(accountRequest.getFirstName());
				user.setKanaFirstName(accountRequest.getKanaFirstName());
				user.setKanaLastName(accountRequest.getKanaLastName());
				user.setLastName(accountRequest.getLastName());
				user.setPostalCode(accountRequest.getPostalCode());
				user.setPrefecture(accountRequest.getPrefecture());
				user.setEmail(accountRequest.getEmail());
				user.setPassword(encryptedPassword);
				user.setCompanyAddress(accountRequest.getCompanyAddress());
				user.setDivision(accountRequest.getDivision());
				user.setPhoneNumber(accountRequest.getPhoneNumber());
				user.setMobilePhoneNumber(accountRequest.getPhoneNumber());
				// user = userService.storeUser(user);
				user = usersRepository.save(user);
				// user Role Mapping
				UserRoleMappingPK userRoleMappingPK = new UserRoleMappingPK();
				userRoleMappingPK.setUserId(user.getUserId());
				userRoleMappingPK.setRoleId(userType);
				UserRoleMapping userRoleMapping = new UserRoleMapping();
				userRoleMapping.setId(userRoleMappingPK);
				userRoleMapping.setUser(user);
				userRoleMappingRepository.save(userRoleMapping);
				// store user Customer Profile Mapping
				UserServiceMappingPK userServiceMappingPK = null;
				UserServiceMapping userServiceMapping = null;
					for (Integer serviceId : accountRequest.getServiceIds()) {
						userServiceMappingPK = new UserServiceMappingPK();
						userServiceMapping = new UserServiceMapping();
						userServiceMappingPK.setServiceId(serviceId);
						userServiceMappingPK.setRoleId(userType);
						userServiceMappingPK.setUserId(user.getUserId());
						//userServiceMappingPK.setUser(user);
						userServiceMapping.setId(userServiceMappingPK);
						userServiceMappingRepository.save(userServiceMapping);
					}
			
			}
			catch (Exception e) {				
				logger.log(Level.TRACE, e.getLocalizedMessage());
				
			}
			return user;
		}
	

}
