package com.webservices.dto;

import com.webservices.modal.Service;

public class ServiceResponse {

	private Integer serviceId;	
	private String name;
	public ServiceResponse(Service services) {
		this.serviceId = services.getServiceId();
		this.name=services.getName();
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
