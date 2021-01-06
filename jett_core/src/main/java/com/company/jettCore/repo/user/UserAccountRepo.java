package com.company.jettCore.repo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.jettCore.model.user.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
	
	@Query(value="SELECT & FROM user_account o WHERE o.status=?1", nativeQuery = true)
	public List<UserAccount> findUserAccountByStatus(String status);
	
	@Query(value="SELECT * FROM user_account o WHERE o.code=?1", nativeQuery = true)
	public UserAccount findUserAccountByCode(String code);
	
}
