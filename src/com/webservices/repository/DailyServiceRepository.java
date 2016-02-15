package com.webservices.repository;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservices.modal.DailyService;

@Repository("dailyServiceRepository")
public interface DailyServiceRepository extends JpaRepository<DailyService, Long> {

	  @Query("select b from DailyService b " +
	         "where b.id.createDate between ?1 and ?2 and b.id.createDate between ?1 and ?2")
	  List<Book> findByDatesBetween(Date departure, Date arrival);
	}