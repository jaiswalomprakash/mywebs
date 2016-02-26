package com.webservices.custom.modal;

import java.util.Date;

import com.webservices.modal.Services;

public class ServiceResponse {

	private Long serviceId;	
	private String name;
	public ServiceResponse(Services services) {
		this.serviceId = services.getServiceId();
		this.name=services.getName();
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
