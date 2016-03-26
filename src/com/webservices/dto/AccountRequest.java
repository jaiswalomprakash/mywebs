package com.webservices.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequest implements Serializable {
	
	
	@JsonProperty("access_token")
	String accessToken;
	 @JsonProperty("first_name")
	String firstName;
	 @JsonProperty("last_name")
	String lastName;
	 @JsonProperty("postal_code")
	String postalCode;
	
	String prefecture;
	 @JsonProperty("company_address")
	String companyAddress;	
	 @JsonProperty("kana_first_name")
	String kanaFirstName;
	 @JsonProperty("kana_last_name")
	String kanaLastName;	
	 
	String email;
	String password;
	 @JsonProperty("phone_number")
	String phoneNumber;
	String division;
	 @JsonProperty("user_type")
	String userType;
	 @JsonProperty("service_ids")
	Integer [] serviceIds;
	
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getKanaFirstName() {
		return kanaFirstName;
	}
	public void setKanaFirstName(String kanaFirstName) {
		this.kanaFirstName = kanaFirstName;
	}
	public String getKanaLastName() {
		return kanaLastName;
	}
	public void setKanaLastName(String kanaLastName) {
		this.kanaLastName = kanaLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer[] getServiceIds() {
		return serviceIds;
	}
	public void setServiceIds(Integer[] serviceIds) {
		this.serviceIds = serviceIds;
	}
	


}
