package com.petstore.dao;

import org.springframework.stereotype.Component;

import com.petstore.domain.Account;


public interface AccountDAO {
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public int getAccountByUsername1(String username);
	 /**
		 * 登陆
		 * @param username
		 * @return
		 */
	  Integer getAccountByUsernameAndPassword(Account account);

	  void insertAccount(Account account);
	  
	 

	  void updateAccount(Account account);

	 
	  Account getAccountByUsername(String username);
     
}
