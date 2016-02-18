package com.webservices.services;

import java.util.List;

import com.webservices.modal.DailyService;


public interface DailyBasisService {
	
	public DailyService storeDailyBasisService(DailyService dailyService);
	public List<DailyService> getDailyBasisService() ;
}
