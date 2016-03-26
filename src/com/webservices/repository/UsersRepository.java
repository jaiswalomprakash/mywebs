package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservices.modal.User;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<User, Long>{	
	@Query("select user from User user where (user.email=:email or phoneNumber=:email) ")
	 User login(@Param("email") String email);
	
	
	@Query("select user from User user where user.email=:email")
	 User getuserByEmail(@Param("email") String email);

}
