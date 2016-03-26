package com.webservices.modal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the services database table.
 * 
 */
@Entity
@Table(name="services")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="service_id", unique=true, nullable=false)
	private int serviceId;

	@Column(name="company_location")
	private String companyLocation;

	@Column(name="company_name", length=255)
	private String companyName;

	@Column(nullable=false, length=255)
	private String name;

	@Column(name="person_incharge", length=255)
	private String personIncharge;

	@Column(name="person_incharge_division", length=255)
	private String personInchargeDivision;

	@Column(name="person_incharge_email", length=255)
	private String personInchargeEmail;

	@Column(name="person_incharge_phonenumber", length=255)
	private String personInchargePhonenumber;

	@Column(nullable=false, length=255)
	private String uuid;

	//bi-directional many-to-one association to MyService
	@OneToMany(mappedBy="service")
	private List<MyService> myServices;

	//bi-directional many-to-one association to UserServiceMapping
	@OneToMany(mappedBy="service")
	private List<UserServiceMapping> userServiceMappings;

	public Service() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getCompanyLocation() {
		return this.companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonIncharge() {
		return this.personIncharge;
	}

	public void setPersonIncharge(String personIncharge) {
		this.personIncharge = personIncharge;
	}

	public String getPersonInchargeDivision() {
		return this.personInchargeDivision;
	}

	public void setPersonInchargeDivision(String personInchargeDivision) {
		this.personInchargeDivision = personInchargeDivision;
	}

	public String getPersonInchargeEmail() {
		return this.personInchargeEmail;
	}

	public void setPersonInchargeEmail(String personInchargeEmail) {
		this.personInchargeEmail = personInchargeEmail;
	}

	public String getPersonInchargePhonenumber() {
		return this.personInchargePhonenumber;
	}

	public void setPersonInchargePhonenumber(String personInchargePhonenumber) {
		this.personInchargePhonenumber = personInchargePhonenumber;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<MyService> getMyServices() {
		return this.myServices;
	}

	public void setMyServices(List<MyService> myServices) {
		this.myServices = myServices;
	}

	public MyService addMyService(MyService myService) {
		getMyServices().add(myService);
		myService.setService(this);

		return myService;
	}

	public MyService removeMyService(MyService myService) {
		getMyServices().remove(myService);
		myService.setService(null);

		return myService;
	}

	public List<UserServiceMapping> getUserServiceMappings() {
		return this.userServiceMappings;
	}

	public void setUserServiceMappings(List<UserServiceMapping> userServiceMappings) {
		this.userServiceMappings = userServiceMappings;
	}

	public UserServiceMapping addUserServiceMapping(UserServiceMapping userServiceMapping) {
		getUserServiceMappings().add(userServiceMapping);
		userServiceMapping.setService(this);

		return userServiceMapping;
	}

	public UserServiceMapping removeUserServiceMapping(UserServiceMapping userServiceMapping) {
		getUserServiceMappings().remove(userServiceMapping);
		userServiceMapping.setService(null);

		return userServiceMapping;
	}

}