package com.webservices.modal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id", unique=true, nullable=false)
	private int roleId;

	@Column(nullable=false, length=50)
	private String role;

	//bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy="userRole")
	private List<UserRoleMapping> userRoleMappings;

	//bi-directional many-to-one association to UserServiceMapping
	@OneToMany(mappedBy="userRole")
	private List<UserServiceMapping> userServiceMappings;

	public UserRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(List<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setUserRole(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setUserRole(null);

		return userRoleMapping;
	}

	public List<UserServiceMapping> getUserServiceMappings() {
		return this.userServiceMappings;
	}

	public void setUserServiceMappings(List<UserServiceMapping> userServiceMappings) {
		this.userServiceMappings = userServiceMappings;
	}

	public UserServiceMapping addUserServiceMapping(UserServiceMapping userServiceMapping) {
		getUserServiceMappings().add(userServiceMapping);
		userServiceMapping.setUserRole(this);

		return userServiceMapping;
	}

	public UserServiceMapping removeUserServiceMapping(UserServiceMapping userServiceMapping) {
		getUserServiceMappings().remove(userServiceMapping);
		userServiceMapping.setUserRole(null);

		return userServiceMapping;
	}

}