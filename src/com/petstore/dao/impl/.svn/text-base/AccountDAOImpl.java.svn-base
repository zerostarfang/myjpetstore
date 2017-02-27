package com.petstore.dao.impl;



import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.petstore.dao.AccountDAO;
import com.petstore.domain.Account;
@Component("accountDAO")
public class AccountDAOImpl implements AccountDAO{
	public HibernateTemplate hb;
	@Resource(name="hibernateTemplate")
	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}
	@Override
	public int getAccountByUsername1(String username) {
		
		if( hb.find("from Account where userid=?", username).isEmpty()||hb.find("from Account where userid=?", username).get(0)==null)
		   return 0;
		 return 1;
	}

	@Override
	public Integer getAccountByUsernameAndPassword(Account account) {
		Account account2 =new Account();
		account2=(Account)hb.find("from Account where userid=?", account.getUsername()).get(0);
		if(account2==null || !account2.getPassword().equals(account.getPassword()))
			return 0;
		return 1;
	}

	@Override
	public void insertAccount(Account account) {
		 Session session=hb.getSessionFactory().openSession();
		  session.beginTransaction();
		  session.save(account);
		  session.getTransaction().commit();
		  session.close();
		
	}

	@Override
	public void updateAccount(Account account) {
		  Session session=hb.getSessionFactory().openSession();
		  session.beginTransaction();
		  Query query=session.createQuery("update Account set password=? where userid=?");
		  query.setString(0, account.getPassword().trim());
		  query.setString(1, account.getUsername().trim());
		  query.executeUpdate();
		  session.getTransaction().commit();
		  session.close();
		 System.out.println("PPPPPPPPP"+account.getUsername());
	}

	@Override
	public Account getAccountByUsername(String username) {
		
		return (Account)hb.find("from Account where userid=?", username).get(0);
	}
	
	
	/*Session session=null;
	Transaction tx=null;
	
	
	@Override
	public int getAccountByUsername1(String username) {
		Account account=new Account();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
    try {

		Query query= session.createQuery("from Account where userid=?");
		
		query.setString(0, username);
		account=(Account)query.uniqueResult();//如果这里用的是load方法下面就不能用account==null来判断是否为空  因为load可以在实现懒加载  会生成一个类来继承
		if(account==null)
		  return 0;
	
	} catch (Exception e) {
		e.printStackTrace();
		  
	}finally{
		tx.commit();
		session.close();
	}
	  return 1;
	}

	@Override
	public Account getAccountByUsername(String username) {
		
		Account account=new Account();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		try {
			Query query= session.createQuery();
			query.setString(0, username);
			account=(Account)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			tx.commit();
			session.close();
		}
		return account;
	}

	@Override
	public Integer getAccountByUsernameAndPassword(Account account) {
		
		String name=account.getUsername();
		String password=account.getPassword();
		Account account2=new Account();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		
		try {
			//Query query= session.createQuery("from Account where userid=?");
		///	query.setString(0, name);
			//account2=(Account)query.uniqueResult(); 
			account2=(Account)session.get(Account.class, name);
		//	tx.commit();
		//	session.close();
			
		//	session=HibernateUtil.getSession();
		//	tx=session.beginTransaction();
		//	Account account3=new Account();
		//	account3=(Account)session.get(Account.class, name);
		//	account3.getAddress1();
			if(account2==null || !account2.getPassword().equals(password))
				return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			tx.commit();
			session.close();
		}
		return 1;
	}

	@Override
	public void insertAccount(Account account) {
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		try {
			session.save(account);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			tx.commit();
			session.close();
		}
		
		
	}



	@Override
	public void updateAccount(Account account) {
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		try {
			session.update(account);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tx.commit();
			session.close();
		}
		
		
	}

	}
*/


	

}
