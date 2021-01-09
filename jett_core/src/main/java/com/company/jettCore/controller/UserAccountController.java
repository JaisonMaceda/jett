package com.company.jettCore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.jettCore.model.user.UserAccount;
import com.company.jettCore.service.user.UserAccountService;

@CrossOrigin(origins= "http://localhost:8081")
@RestController
@RequestMapping("/userAccount")
public class UserAccountController{
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value="/findAll")
	public List<UserAccount> findAllUserAccount() {	
		return userAccountService.findAll();
	}
	
	@RequestMapping(value="/findById/{id}")
	public UserAccount findByIdUserAccount(@PathVariable("id") String id) {	
		return userAccountService.findById(Long.parseLong(id));
	}
	
	@RequestMapping(value="/findByCode/{code}")
	public UserAccount findByCodeUserAccount(@PathVariable("code") String code) {	
		return userAccountService.findByCode(code);
	}

	


}
