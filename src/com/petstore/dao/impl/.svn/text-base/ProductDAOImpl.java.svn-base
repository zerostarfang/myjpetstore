package com.petstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.petstore.commons.DbUtil;
import com.petstore.commons.HibernateUtil;
import com.petstore.dao.ProductDAO;
import com.petstore.domain.Category;
import com.petstore.domain.Product;
@Component("productDAO")
public class ProductDAOImpl implements ProductDAO{

	HibernateTemplate hb;
	
	@Override
	public List<Product> getProductListByCategory(String categoryId) {
		Set set=new HashSet<Product>();
		set=((Category)hb.find("from Category where categoryId=?", categoryId).get(0)).getProducts();
		 List<Product> list=new ArrayList<Product>(set);
		return list  ;
	}

	@Override
	public Product getProduct(String productId) {
		
		return (Product)hb.find("from Product where productId=?", productId).get(0);
	}

	@Override
	public List<Product> searchProductList(String keywords) {
		 
		return hb.find("from Product where productId like ?", keywords);
	}

	@Resource(name="hibernateTemplate")
	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}

	
	
	/*Session session=null;
	Transaction tx=null;
	@Override
	public List<Product> getProductListByCategory(String categoryId) {
		
		Set set=new HashSet<Product>();
		Product product=null;
		Category category=new Category();
        session=HibernateUtil.getSession();
        tx=session.beginTransaction();
        Query query=session.createQuery("from Category where categoryId=?");
        query.setString(0, categoryId);
        category=(Category)query.uniqueResult();
        set=category.getProducts();
        List<Product> list=new ArrayList<Product>(set);
        tx.commit();
        session.close();
		return list;
	}
	@Override
	public Product getProduct(String productId) {
		Product product=new Product();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		Query query=session.createQuery("from Product where productId=?");
		query.setString(0, productId);
		product=(Product)query.uniqueResult();		
		tx.commit();
		session.close();
		return product;
	}
	@Override
	public List<Product> searchProductList(String keywords) {
		
		 List<Product> list=new ArrayList<Product>();
		
        session=HibernateUtil.getSession();
        tx=session.beginTransaction();
        Query query=session.createQuery("from Product where productId like ?");
        query.setString(0, keywords);
        list=query.list();
        tx.commit();
        session.close();
		return list;
	}*/

	/*@Override
	public Product getProduct(String productId) {
		Product product=null;
        try {
			con=DbUtil.newInstance().getConnection();
			String sql=" SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1, productId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				product = new Product();
				product.setProductId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setCategoryId(rs.getString(4));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public List<Product> searchProductList(String keywords) {
		List<Product> list=new ArrayList<Product>();
		Product product=null;
        try {
			con=DbUtil.newInstance().getConnection();
			String sql="  select PRODUCTID, NAME, DESCN as description,CATEGORY as categoryId from PRODUCT WHERE lower(CATEGORY) like ?";
			pst=con.prepareStatement(sql);
			String key=keywords;
			pst.setString(1, key);
			rs=pst.executeQuery();
			while(rs.next())
			{
				product = new Product();
				product.setProductId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setCategoryId(rs.getString(4));
				list.add(product);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
*/
}
