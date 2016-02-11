package com.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservices.modal.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long>{	
	@Query("select user from Users user where user.email=:email ")
	 Users login(@Param("email") String email);

}
