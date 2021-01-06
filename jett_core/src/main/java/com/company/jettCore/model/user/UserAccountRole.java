package com.company.jettCore.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.company.jettCore.model.JPAEntity;

@Entity
public class UserAccountRole extends JPAEntity{
	@Column(name = "code")
	private String code;
	
	@JoinColumn(name="user_account_role_type_id")
	@ManyToOne
	private UserAccountRoleType roleType;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserAccountRoleType getRole() {
		return roleType;
	}

	public void setRole(UserAccountRoleType role) {
		this.roleType = role;
	}
	
	
}
