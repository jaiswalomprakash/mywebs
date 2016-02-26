package com.webservices.custom.modal;

import java.util.Date;
import java.util.List;

import com.webservices.exception.GenericReponse;
import com.webservices.modal.Users;

public class LoginResponse extends GenericReponse {
	
	private Integer userId;	
	private String active;
	private String companyAddress;
	private String companyName;
	private Date createDate;
	private String division;
	private String email;
	private String mobilePhoneNumber;
	private String password;
	private String phoneNumber;
	private String realname;
	private String title;
	private byte[] userImage;
	private String userImageFilename;	
	private List<ServiceResponse> services;
	
	public List<ServiceResponse> getServices() {
		return services;
	}

	public void setServices(List<ServiceResponse> services) {
		this.services = services;
	}

	private String token;
	
	public LoginResponse(Users user) {
		this.userId = user.getUserId();
		this.email=user.getEmail();
		this.mobilePhoneNumber=user.getMobilePhoneNumber();
		this.realname=user.getRealname();
		
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getUserImageFilename() {
		return userImageFilename;
	}

	public void setUserImageFilename(String userImageFilename) {
		this.userImageFilename = userImageFilename;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
	

}
