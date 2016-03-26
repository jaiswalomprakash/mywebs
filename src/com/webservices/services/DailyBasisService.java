package com.webservices.services;

import java.util.Date;
import java.util.List;

import com.webservices.modal.DailyService;


public interface DailyBasisService {
	
	public DailyService storeDailyBasisService(DailyService dailyService);
	public List<DailyService> getDailyBasisService() ;
	public DailyService getDailyBasisServiceById(Integer serviceId) ;
	public List<DailyService> findByDatesBetween(Date startDate,Date endDate,Integer serviceId);
}
