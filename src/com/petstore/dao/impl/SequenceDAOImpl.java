package com.petstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.petstore.commons.DbUtil;
import com.petstore.dao.SequenceDAO;
import com.petstore.domain.Sequence;
@Component("sequenceDAO")
public class SequenceDAOImpl implements SequenceDAO{

	@Override
	public Sequence getSequence(Sequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSequence(Sequence sequence) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	@Override
	public Sequence getSequence(Sequence sequence) {
		String sql="SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
		Sequence s=new Sequence();
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, sequence.getName());
			rs=pst.executeQuery();
			while(rs.next())
			{
				s.setName(rs.getString(1));
				s.setNextId(rs.getInt(2));
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
		return s;
	}

	@Override
	public void updateSequence(Sequence sequence) {
		String sql=" UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";
		try {
			conn=DbUtil.newInstance().getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, sequence.getNextId());
			pst.setString(2, sequence.getName());
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
