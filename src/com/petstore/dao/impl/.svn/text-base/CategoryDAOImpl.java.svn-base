package com.petstore.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.petstore.dao.CategoryDAO;
import com.petstore.domain.Category;
@Component("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
   HibernateTemplate hb;
   
	@Override
	public List<Category> getCategoryList() {
		
		return  hb.find("from Category");
	}

	@Override
	public Category getCategory(String categoryId) {
		
		return (Category)hb.find("from Category where categoryId=?", categoryId).get(0);
	}

	@Override
	public List<String> getCategoryNameByWords(String word) {
		 
		return hb.find("select name from Category where name like ?" , word);
	}
    
	
	@Resource(name="hibernateTemplate")
	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}
	
	
	
  /*  private Session session=null;
    private Transaction tx=null;
	
	
	@Override
	public List<Category> getCategoryList() {
		List<Category> list=new ArrayList<Category>();
		
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		list=session.createQuery("from Category").list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public Category getCategory(String categoryId)  {
		Category category=null;
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		
		Query query=session.createQuery("from Category where categoryId=?");
		query.setString(0, categoryId);
		category=(Category)query.uniqueResult();
		tx.commit();
		session.close();
		return category;
	}

	@Override
	public List<String> getCategoryNameByWords(String word) {
		List<String> categorys=new ArrayList<String>();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		Query query=session.createQuery("select name from Category where name like ? ");
		query.setString(0, word);
		categorys=query.list();
		tx.commit();
		session.close();
		return categorys;
	}
*/
}
