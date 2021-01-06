package com.company.jettCore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.jettCore.model.user.UserAccount;
import com.company.jettCore.service.user.UserAccountService;

@RestController
public class UserAccountController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value="/findAll")
	public List<UserAccount> findAllUserAccount() {
		
		return userAccountService.findAll();
	}
}
