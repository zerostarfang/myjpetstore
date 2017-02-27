package com.petstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.domain.LineItem;

public interface LineItemDAO {
	
	List<LineItem> getLineItemsByOrderId(int orderId);

	 void insertLineItem(LineItem lineItem);

}
