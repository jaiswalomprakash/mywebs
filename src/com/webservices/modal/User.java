package com.webservices.modal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id", unique=true, nullable=false)
	private int userId;

	@Column(length=1)
	private String active;

	@Column(name="company_address", length=255)
	private String companyAddress;

	@Column(name="company_name", length=255)
	private String companyName;

	@Column(length=255)
	private String division;

	@Column(nullable=false, length=255)
	private String email;

	@Column(name="first_name", length=225)
	private String firstName;

	@Column(name="kana_first_name", length=225)
	private String kanaFirstName;

	@Column(name="kana_last_name", length=225)
	private String kanaLastName;

	@Column(name="last_name", length=225)
	private String lastName;

	@Column(name="mobile_phone_number", length=255)
	private String mobilePhoneNumber;

	@Column(nullable=false, length=255)
	private String password;

	@Column(name="phone_number", length=255)
	private String phoneNumber;

	@Column(name="postal_code", length=20)
	private String postalCode;

	@Column(length=100)
	private String prefecture;

	@Column(name="real_name", length=255)
	private String realName;

	@Column(length=255)
	private String title;

	@Column(name="user_image_filename", length=255)
	private String userImageFilename;

	//bi-directional many-to-one association to MyService
	@OneToMany(mappedBy="user")
	private List<MyService> myServices;

	//bi-directional many-to-one association to UserAccesstoken
	@OneToMany(mappedBy="user")
	private List<UserAccesstoken> userAccesstokens;

	//bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy="user")
	private List<UserRoleMapping> userRoleMappings;

	//bi-directional many-to-one association to UserServiceMapping
	@OneToMany(mappedBy="user")
	private List<UserServiceMapping> userServiceMappings;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getKanaFirstName() {
		return this.kanaFirstName;
	}

	public void setKanaFirstName(String kanaFirstName) {
		this.kanaFirstName = kanaFirstName;
	}

	public String getKanaLastName() {
		return this.kanaLastName;
	}

	public void setKanaLastName(String kanaLastName) {
		this.kanaLastName = kanaLastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhoneNumber() {
		return this.mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserImageFilename() {
		return this.userImageFilename;
	}

	public void setUserImageFilename(String userImageFilename) {
		this.userImageFilename = userImageFilename;
	}

	public List<MyService> getMyServices() {
		return this.myServices;
	}

	public void setMyServices(List<MyService> myServices) {
		this.myServices = myServices;
	}

	public MyService addMyService(MyService myService) {
		getMyServices().add(myService);
		myService.setUser(this);

		return myService;
	}

	public MyService removeMyService(MyService myService) {
		getMyServices().remove(myService);
		myService.setUser(null);

		return myService;
	}

	public List<UserAccesstoken> getUserAccesstokens() {
		return this.userAccesstokens;
	}

	public void setUserAccesstokens(List<UserAccesstoken> userAccesstokens) {
		this.userAccesstokens = userAccesstokens;
	}

	public UserAccesstoken addUserAccesstoken(UserAccesstoken userAccesstoken) {
		getUserAccesstokens().add(userAccesstoken);
		userAccesstoken.setUser(this);

		return userAccesstoken;
	}

	public UserAccesstoken removeUserAccesstoken(UserAccesstoken userAccesstoken) {
		getUserAccesstokens().remove(userAccesstoken);
		userAccesstoken.setUser(null);

		return userAccesstoken;
	}

	public List<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(List<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setUser(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setUser(null);

		return userRoleMapping;
	}

	public List<UserServiceMapping> getUserServiceMappings() {
		return this.userServiceMappings;
	}

	public void setUserServiceMappings(List<UserServiceMapping> userServiceMappings) {
		this.userServiceMappings = userServiceMappings;
	}

	

}