package com.company.jett.model.login;

import javax.persistence.Column;

import com.company.jett.enums.UserAccountRoleType;
import com.company.jett.model.JPAEntity;




public class UserAccountRole extends JPAEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name = "role")
	private UserAccountRoleType role;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserAccountRoleType getRole() {
		return role;
	}

	public void setRole(UserAccountRoleType role) {
		this.role = role;
	}
	
	
}
