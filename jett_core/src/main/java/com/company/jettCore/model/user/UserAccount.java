package com.company.jettCore.model.user;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.company.jettCore.model.JPAEntity;
import com.company.jettCore.model.enums.StatusType;
import com.company.jettCore.util.StringUtil;



@Table(name = "user_account")
@Entity
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
	
	@JoinColumn(name="user_account_position_type_id")
	@ManyToOne
	private UserAccountPositionType positionType;
	
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	@JoinColumn(name="user_account_role_id")
	@ManyToOne
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
		try {
			this.password = StringUtil.hash256(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEncryptedPassword(String password) {
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

	public UserAccountPositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(UserAccountPositionType positionType) {
		this.positionType = positionType;
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
	
	public void updateUserAccount(UserAccount userAccount) {
		this.setId(userAccount.getId());
		this.setVersion(userAccount.getVersion());
		this.setCode(userAccount.getCode());
		this.setEmail(userAccount.getEmail());
		this.setEnable(userAccount.getEnable());
		this.setName(userAccount.getName());
		this.setEncryptedPassword(userAccount.getPassword());
		this.setPositionType(userAccount.getPositionType());
		this.setStatus(userAccount.getStatus());
		this.setUserAccountRole(userAccount.getUserAccountRole());
	}
}
