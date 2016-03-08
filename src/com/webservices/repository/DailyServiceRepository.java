package com.webservices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservices.modal.DailyService;

@Repository("dailyServiceRepository")
public interface DailyServiceRepository extends JpaRepository<DailyService, Long> {

	  @Query("select b from DailyService b where b.createDate >= :startDate and b.createDate <=:endDate and b.services.serviceId= :serviceId order by b.id desc ")
	  List<DailyService> findByDatesBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("serviceId") Long serviceId);
	  
	  	  
	}
