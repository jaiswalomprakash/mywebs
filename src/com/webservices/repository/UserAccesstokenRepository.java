package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservices.modal.UserAccesstoken;

/**
 * UserAccesstokenRepository Interface
 * @author om
 *
 */
@Repository("userAccesstoken")
public interface UserAccesstokenRepository extends JpaRepository<UserAccesstoken, Long>{
	
	@Query("select UserAccesstoken from UserAccesstoken userAccesstoken where userAccesstoken.token=:token ) ")
	 UserAccesstoken getAccessTokenBytoken(@Param("token") String tokan);
	
	 
	
	

}
