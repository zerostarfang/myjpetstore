package com.petstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.petstore.domain.Category;

public interface CategoryDAO {
	/**
	 * 得到所有商品的种类
	 * 
	 * @return
	 */
	List<Category> getCategoryList();

	/**
	 * 根据种类名得到种类
	 * 
	 * @param categoryId
	 * @return
	 */

	Category getCategory(String categoryId);
	
	List<String> getCategoryNameByWords(String word);
	
}
