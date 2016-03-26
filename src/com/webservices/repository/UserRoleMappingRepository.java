package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRoleMappingRepository Interface
 * @author om
 *
 */
@Repository("userRoleMappingRepository")
public interface UserRoleMappingRepository extends JpaRepository<com.webservices.modal.UserRoleMapping, Long>{
	
	
	

}
