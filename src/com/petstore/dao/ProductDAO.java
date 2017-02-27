package com.petstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.domain.Product;

public interface ProductDAO {
	/**
	 * 根据种类得到产品列表
	 * @param categoryId
	 * @return
	 */
	  List<Product> getProductListByCategory(String categoryId);

	  /**
	   * 根据产品名得到产品信息
	   * @param productId
	   * @return
	   */
	  Product getProduct(String productId);
      
	  /**
	   * 根据关键字搜索产品
	   * @param keywords
	   * @return
	   */
	  List<Product> searchProductList(String keywords);

}
