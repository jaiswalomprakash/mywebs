package com.webservices.dto;

import java.util.List;

import com.webservices.exception.GenericReponse;
import com.webservices.modal.DailyService;

public class DailyServiceList extends GenericReponse {
	
	List<DailyService> dailyServices;

	public List<DailyService> getDailyServices() {
		return dailyServices;
	}

	public void setDailyServices(List<DailyService> dailyServices) {
		this.dailyServices = dailyServices;
	}
	
	

}
