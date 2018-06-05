package com.alethia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserBean {

	@Id
	@Column(name="User_ID")
	private String UserId;
	
	@NotNull
	@Column(name="FullName")
	@Size(min=2, message="Name should have atleast 2 characters")
	private String fullName;
	
	@NotNull
	@Email(message="Enter a valid emailId")
	@Column(name="EmailAddress")
	private String emailId;
	
	@NotNull
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Column(name="Created_date")
	private String createdDate;
	
	@NotNull
	@Column(name="Role_ID")
	private String roleId;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
}
