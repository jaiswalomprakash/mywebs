package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRoleMappingRepository Interface
 * @author om
 *
 */
@Repository("userServiceMapping")
public interface UserServiceMappingRepository extends JpaRepository<com.webservices.modal.UserServiceMapping, Long>{
	
	
	

}
