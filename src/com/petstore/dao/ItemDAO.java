package com.petstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.petstore.domain.Item;

public interface ItemDAO {
	/**
	 * 更新存货数量
	 * @param param
	 */
	void updateInventoryQuantity(Map<String, Object> param);

	
	  /**
	   * 根据产品名得到产品明细
	   * @param productId
	   * @return
	   */
	  List<Item> getItemListByProduct(String productId);
      
	  /**
	   * 根据产品明细名得到产品明细
	   * @param itemId
	   * @return
	   */
	  Item getItem(String itemId);

}
