package com.company.jettCore.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.company.jettCore.model.user.UserAccount;
import com.company.jettCore.repo.user.UserAccountRepo;
import com.company.jettCore.service.AbstractDomainService;

@Transactional
@Service
public class UserAccountServiceImpl extends AbstractDomainService<UserAccount> implements UserAccountService {
	
	@Autowired
	private UserAccountRepo userAccountRepo;

	@Override
	public void update(UserAccount t) {
		if(t != null) {
			UserAccount userAccountCurrent = findById(t.getId());
			
			t.updateUserAccount(userAccountCurrent);
		}
		userAccountRepo.save(t);	
	}
	
	@Override
	public UserAccount findByCode(String code) {
		return userAccountRepo.findUserAccountByCode(code);	
	}
	
	@Override
	protected JpaRepository<UserAccount, Long> getRepo() {
		return userAccountRepo;
	}

}
