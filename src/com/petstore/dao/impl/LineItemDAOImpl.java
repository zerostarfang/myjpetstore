package com.petstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.commons.DbUtil;
import com.petstore.dao.LineItemDAO;
import com.petstore.domain.LineItem;
@Component("lineItemDAO")
public class LineItemDAOImpl implements LineItemDAO{

	@Override
	public List<LineItem> getLineItemsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLineItem(LineItem lineItem) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	@Override
	public List<LineItem> getLineItemsByOrderId(int orderId) {
		String sql="SELECT ORDERID,LINENUM AS lineNumber,ITEMID,QUANTITY,UNITPRICE FROM LINEITEM WHERE ORDERID = ?";
		LineItem lineItem;
		List<LineItem> list=new ArrayList<LineItem>();
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, orderId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				lineItem=new LineItem();
				lineItem.setOrderId(orderId);
				lineItem.setLineNumber(rs.getInt(2));
				lineItem.setItemId(rs.getString(3));
				lineItem.setQuantity(rs.getInt(4));
				lineItem.setUnitPrice(rs.getBigDecimal(5));
				list.add(lineItem);
				
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
	public void insertLineItem(LineItem lineItem) {
		String  sql="INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, lineItem.getOrderId());
			pst.setInt(2, lineItem.getLineNumber());
			pst.setString(3, lineItem.getItemId());
			pst.setInt(4, lineItem.getQuantity());
			pst.setBigDecimal(5, lineItem.getUnitPrice());
			
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
*/
}








