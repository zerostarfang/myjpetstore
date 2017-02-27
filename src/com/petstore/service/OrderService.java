package com.petstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.petstore.dao.ItemDAO;
import com.petstore.dao.LineItemDAO;
import com.petstore.dao.OrderDAO;
import com.petstore.dao.SequenceDAO;
import com.petstore.dao.impl.ItemDAOImpl;
import com.petstore.dao.impl.LineItemDAOImpl;
import com.petstore.dao.impl.OrderDAOImpl;
import com.petstore.dao.impl.SequenceDAOImpl;
import com.petstore.domain.Item;
import com.petstore.domain.LineItem;
import com.petstore.domain.Order;
import com.petstore.domain.Sequence;

public class OrderService {
	
	
	  private ItemDAO itemMapper=new ItemDAOImpl();
	 
	  private OrderDAO orderMapper=new OrderDAOImpl();
	
	  private SequenceDAO sequenceMapper=new SequenceDAOImpl();
	 
	  private LineItemDAO lineItemMapper=new LineItemDAOImpl();

	  
	  public void insertOrder(Order order) {
	    order.setOrderId(getNextId("ordernum"));
	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      String itemId = lineItem.getItemId();
	      Integer increment = new Integer(lineItem.getQuantity());
	      Map<String, Object> param = new HashMap<String, Object>(2);
	      param.put("itemId", itemId);
	      param.put("increment", increment);
	      itemMapper.updateInventoryQuantity(param);
	    }

	    orderMapper.insertOrder(order);
	    orderMapper.insertOrderStatus(order);
	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      lineItem.setOrderId(order.getOrderId());
	      lineItemMapper.insertLineItem(lineItem);
	    }
	  }

	  
	  public Order getOrder(int orderId) {
	    Order order = orderMapper.getOrder(orderId);
	    order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));

	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      Item item = itemMapper.getItem(lineItem.getItemId());
	      item.setQuantity(itemMapper.getItem(lineItem.getItemId()).getQuantity());
	      lineItem.setItem(item);
	    }

	    return order;
	  }

	  public List<Order> getOrdersByUsername(String username) {
	    return orderMapper.getOrdersByUsername(username);
	  }

	  public int getNextId(String name) {
	    Sequence sequence = new Sequence(name, -1);
	    sequence = (Sequence) sequenceMapper.getSequence(sequence);
	    if (sequence == null) {
	      throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
	          + " sequence).");
	    }
	    Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
	    sequenceMapper.updateSequence(parameterObject);
	    return sequence.getNextId();
	  }

}
