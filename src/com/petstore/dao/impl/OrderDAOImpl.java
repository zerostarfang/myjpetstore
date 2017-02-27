package com.petstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.commons.DbUtil;
import com.petstore.dao.OrderDAO;
import com.petstore.domain.Account;
import com.petstore.domain.Order;
//@Component("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	@Override
	public List<Order> getOrdersByUsername(String username) {
		List<Order> list=new ArrayList<Order>();
		try {
			 conn=DbUtil.newInstance().getConnection();
	         String sql=" SELECT BILLADDR1 AS billAddress1,BILLADDR2 AS billAddress2,BILLCITY,BILLCOUNTRY,BILLSTATE,BILLTOFIRSTNAME,BILLTOLASTNAME,BILLZIP,SHIPADDR1 AS shipAddress1,SHIPADDR2 AS shipAddress2,SHIPCITY,SHIPCOUNTRY,SHIPSTATE,SHIPTOFIRSTNAME,SHIPTOLASTNAME,SHIPZIP,CARDTYPE,COURIER,CREDITCARD,EXPRDATE AS expiryDate,LOCALE,ORDERDATE,ORDERS.ORDERID,TOTALPRICE,USERID AS username,STATUS FROM ORDERS, ORDERSTATUS WHERE ORDERS.USERID = ? AND ORDERS.ORDERID = ORDERSTATUS.ORDERID ORDER BY ORDERDATE";
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, username);
			 rs=pst.executeQuery();
			
			Order order;
			while(rs.next())
			{
				order=new Order();
				order.setBillAddress1(rs.getString(1));
				order.setBillAddress2(rs.getString(2));
				order.setBillCity(rs.getString(3));
				order.setBillCountry(rs.getString(4));
				order.setBillState(rs.getString(5));
				order.setBillToFirstName(rs.getString(6));
				order.setBillToLastName(rs.getString(7));
				order.setBillZip(rs.getString(8));
				order.setShipAddress1(rs.getString(9));
				order.setShipAddress2(rs.getString(10));
				order.setShipCity(rs.getString(11));
				order.setShipCountry(rs.getString(12));
				order.setShipState(rs.getString(13));
				order.setShipToFirstName(rs.getString(14));
				order.setShipToLastName(rs.getString(15));
				order.setShipZip(rs.getString(16));
				order.setCardType(rs.getString(17));
				order.setCourier(rs.getString(18));
				order.setCreditCard(rs.getString(19));
				order.setExpiryDate(rs.getString(20));
				order.setLocale(rs.getString(21));
				order.setOrderDate(rs.getDate(22));
				order.setOrderId(rs.getInt(23));
				order.setTotalPrice(rs.getBigDecimal(24));
				order.setUsername(rs.getString(25));
				order.setStatus(rs.getString(26));
				
				list.add(order);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

	@Override
	public Order getOrder(int orderId) {
		Order order=new Order();
		try {
			 conn=DbUtil.newInstance().getConnection();
	        String sql=" SELECT BILLADDR1 AS billAddress1,BILLADDR2 AS billAddress2,BILLCITY,BILLCOUNTRY,BILLSTATE,BILLTOFIRSTNAME,BILLTOLASTNAME,BILLZIP,SHIPADDR1 AS shipAddress1,SHIPADDR2 AS shipAddress2,SHIPCITY,SHIPCOUNTRY,SHIPSTATE,SHIPTOFIRSTNAME,SHIPTOLASTNAME,SHIPZIP,CARDTYPE,COURIER,CREDITCARD,EXPRDATE AS expiryDate,LOCALE,ORDERDATE,ORDERS.ORDERID,TOTALPRICE,USERID AS username,STATUS FROM ORDERS, ORDERSTATUS WHERE ORDERS.ORDERID = ? AND ORDERS.ORDERID = ORDERSTATUS.ORDERID";
			 pst=conn.prepareStatement(sql);
			 pst.setInt(1, orderId);
			 rs=pst.executeQuery();
			while(rs.next())
			{
				order.setBillAddress1(rs.getString(1));
				order.setBillAddress2(rs.getString(2));
				order.setBillCity(rs.getString(3));
				order.setBillCountry(rs.getString(4));
				order.setBillState(rs.getString(5));
				order.setBillToFirstName(rs.getString(6));
				order.setBillToLastName(rs.getString(7));
				order.setBillZip(rs.getString(8));
				order.setShipAddress1(rs.getString(9));
				order.setShipAddress2(rs.getString(10));
				order.setShipCity(rs.getString(11));
				order.setShipCountry(rs.getString(12));
				order.setShipState(rs.getString(13));
				order.setShipToFirstName(rs.getString(14));
				order.setShipToLastName(rs.getString(15));
				order.setShipZip(rs.getString(16));
				order.setCardType(rs.getString(17));
				order.setCourier(rs.getString(18));
				order.setCreditCard(rs.getString(19));
				order.setExpiryDate(rs.getString(20));
				order.setLocale(rs.getString(21));
				order.setOrderDate(rs.getDate(22));
				order.setOrderId(rs.getInt(23));
				order.setTotalPrice(rs.getBigDecimal(24));
				order.setUsername(rs.getString(25));
				order.setStatus(rs.getString(26));	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return order;
	}

	@Override
	public void insertOrder(Order order) {
		String sql=" INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,CREDITCARD, EXPRDATE, CARDTYPE, LOCALE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, order.getOrderId());
			pst.setString(2, order.getUsername());
			pst.setDate(3, (Date) order.getOrderDate());
			pst.setString(4, order.getShipAddress1());
			pst.setString(5, order.getShipAddress2());
			pst.setString(6, order.getShipCity());
			pst.setString(7, order.getShipState());
			pst.setString(8,order.getShipZip() );
			pst.setString(9, order.getShipCountry());
			pst.setString(10, order.getBillAddress1());
			pst.setString(11, order.getBillAddress2());
			pst.setString(12, order.getBillCity());
			pst.setString(13, order.getBillState());
			pst.setString(14, order.getBillZip());
			pst.setString(15, order.getBillCountry());
			pst.setString(16, order.getCourier());
			pst.setBigDecimal(17, order.getTotalPrice());
			pst.setString(18, order.getBillToFirstName());
			pst.setString(19, order.getBillToLastName());
			pst.setString(20, order.getShipToFirstName());
			pst.setString(21, order.getShipToLastName());
			pst.setString(22, order.getCreditCard());
			pst.setString(23, order.getExpiryDate());
			pst.setString(24, order.getCardType());
			pst.setString(25, order.getLocale());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void insertOrderStatus(Order order) {
		String sql=" INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS) VALUES (?, ?, ?, ?)";
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getOrderId());
			pst.setDate(3, (Date)order.getOrderDate());
			pst.setString(4, order.getStatus());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
