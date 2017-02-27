package com.petstore.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.petstore.dao.AccountDAO;
import com.petstore.domain.Account;

@Component("accountService")
public class AccountService {
	
     
	  private AccountDAO accountDAO ;
 
	  public Account getAccount(String username) {
	    return accountDAO.getAccountByUsername(username);
	  }
	  //用于验证用户名是否存在
	  public int getAccount1(String username) {
		    return accountDAO.getAccountByUsername1(username);
		  }
     
	  public Integer getAccount(String username, String password) {
	    Account account = new Account();
	    account.setUsername(username.trim());
	    account.setPassword(password.trim());
	    System.out.println(accountDAO.getAccountByUsernameAndPassword(account)+"dddddddddd");
	    return accountDAO.getAccountByUsernameAndPassword(account);
	  }

	 
	  public void insertAccount(Account account) {
		  if(accountDAO.getAccountByUsername1(account.getUsername())==0)
		       accountDAO.insertAccount(account);
		  /////////在这里要自定义异常
			  
	  }

	 
	  public void updateAccount(Account account) {
		//  System.out.println("PPPPPPPPP"+account.getUsername());
		  
	    if (account.getPassword() != null && account.getPassword().length() > 0) {
	    	 
	    	accountDAO.updateAccount(account);
	    	
	    }
	  }
	  @Resource(name="accountDAO")
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	

}
