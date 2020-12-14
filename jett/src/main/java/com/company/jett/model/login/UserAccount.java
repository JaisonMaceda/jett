package com.company.jett.model.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.orm.jpa.EntityScan;

import com.company.jett.enums.StatusType;
import com.company.jett.enums.UserAccountPositionType;
import com.company.jett.model.JPAEntity;



@EntityScan
@Table(name = "user_account")
public class UserAccount extends JPAEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "enable")
	private Boolean enable;
	
	@Column(name = "position")
	private UserAccountPositionType position;
	
	@Column(name = "status")
	private StatusType status;
	
	@JoinColumn(name = "user_account_role_id")
	@OneToMany
	private UserAccountRole userAccountRole;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public UserAccountPositionType getPosition() {
		return position;
	}

	public void setPosition(UserAccountPositionType position) {
		this.position = position;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public UserAccountRole getUserAccountRole() {
		return userAccountRole;
	}

	public void setUserAccountRole(UserAccountRole userAccountRole) {
		this.userAccountRole = userAccountRole;
	}
	
}
