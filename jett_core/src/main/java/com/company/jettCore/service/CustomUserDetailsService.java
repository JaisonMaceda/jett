package com.company.jettCore.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.jettCore.model.user.JettUser;
import com.company.jettCore.model.user.UserAccount;
import com.company.jettCore.service.user.UserAccountService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserAccountService userAccountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount userAccount = userAccountService.findByCode(username);
		if (userAccount == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		String userCode = userAccount.getCode();
		String password = userAccount.getPassword();
		Boolean enabled  = userAccount.getEnable(); 
		Boolean accountNonExpired = true;
		Boolean credentialsNonExpired = true;
		Boolean accountNonLocked = true;
		String role = userAccount.getUserAccountRole().getCode();
		
		JettUser jettUser = new JettUser(userCode, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, Collections.singleton(new SimpleGrantedAuthority(role)));
		return jettUser;
	}

}
