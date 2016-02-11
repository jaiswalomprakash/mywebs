package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservices.modal.UserAccesstoken;
import com.webservices.modal.Users;

@Repository("userAccesstoken")
public interface UserAccesstokenRepository extends JpaRepository<UserAccesstoken, Long>{	
	
	UserAccesstoken save(UserAccesstoken persisted);

}
