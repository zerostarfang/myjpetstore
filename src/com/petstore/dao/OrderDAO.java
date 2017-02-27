package com.petstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.domain.Order;

public interface OrderDAO {
	 List<Order> getOrdersByUsername(String username);

	  Order getOrder(int orderId);
	  
	  void insertOrder(Order order);
	  
	  void insertOrderStatus(Order order);

}
