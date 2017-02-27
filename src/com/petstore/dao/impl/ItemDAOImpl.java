package com.petstore.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.petstore.dao.ItemDAO;
import com.petstore.domain.Item;
import com.petstore.domain.Product;
@Component("itemDAO")
public class ItemDAOImpl implements ItemDAO {

	HibernateTemplate hb;
	
	@Override
	public void updateInventoryQuantity(Map<String, Object> param) {
		 
		// hb.update(" from Item SET QTY = QTY-? WHERE ITEMID = ?", (Integer)param.get("increment"), (String)param.get("itemId"));
		 Item item=(Item)hb.find("from item where itemid=?", param.get("itemId")).get(0);
		 int count=item.getQuantity();
		 item.setQuantity(count-(Integer)param.get("increment"));
		 hb.update(item);
	}

	@Override
	public List<Item> getItemListByProduct(String productId) {
		 
		return   new ArrayList<Item>(((Product)hb.find("from Product where productId=?", productId).get(0)).getItems());
	}

	@Override
	public Item getItem(String itemId) {
		// TODO Auto-generated method stub
		return (Item)hb.find("from Item where itemId = ?", itemId).get(0);
	}

	@Resource(name="hibernateTemplate")
	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}
	
	
	
   /*  Session session=null;
     Transaction tx=null;
	
	
	

	@Override
	public List<Item> getItemListByProduct(String productId) {
		
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		Query query=session.createQuery("from Product where productId=?");
		query.setString(0, productId);
		Product product=(Product)query.uniqueResult();
		List<Item> list=new ArrayList<Item>(product.getItems());
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public Item getItem(String itemId) {
		Item item=new Item();
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		Query query=session.createQuery("from Item where itemId = ?");
		query.setString(0, itemId);
		item=(Item)query.uniqueResult();
		tx.commit();
		session.close();
		return item;
	}

	
	
	@Override
	public void updateInventoryQuantity(Map<String, Object> param) {
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		Query query=session.createQuery("UPDATE Item SET QTY = QTY-? WHERE ITEMID = ?");
		query.setInteger(0, (Integer)param.get("increment"));
		query.setString(1, (String)param.get("itemId"));
		query.executeUpdate();
		tx.commit();
		session.close();
	}
*/
}
