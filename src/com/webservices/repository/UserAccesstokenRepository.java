package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservices.modal.UserAccesstoken;

@Repository("userAccesstoken")
public interface UserAccesstokenRepository extends JpaRepository<UserAccesstoken, Long>{	
	
	//UserAccesstoken saveAndFlush(UserAccesstoken persisted);

}
