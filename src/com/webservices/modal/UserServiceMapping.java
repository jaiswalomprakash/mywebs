package com.webservices.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_service_mapping database table.
 * 
 */
@Entity
@Table(name="user_service_mapping")
@NamedQuery(name="UserServiceMapping.findAll", query="SELECT u FROM UserServiceMapping u")
public class UserServiceMapping extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserServiceMappingPK id;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_id", nullable=false, insertable=false, updatable=false)
	private Service service;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false, insertable=false, updatable=false)
	private UserRole userRole;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
	private User user;

	public UserServiceMapping() {
	}

	public UserServiceMappingPK getId() {
		return this.id;
	}

	public void setId(UserServiceMappingPK id) {
		this.id = id;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}