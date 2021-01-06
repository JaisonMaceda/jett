package com.company.jettCore.model.user;

import javax.persistence.Entity;

import com.company.jettCore.model.JPAEntity;

@Entity
public class UserAccountRoleType extends JPAEntity {

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
