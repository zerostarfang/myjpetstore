package com.petstore.service;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.petstore.dao.CategoryDAO;
import com.petstore.dao.ItemDAO;
import com.petstore.dao.ProductDAO;
import com.petstore.dao.impl.CategoryDAOImpl;
import com.petstore.dao.impl.ItemDAOImpl;
import com.petstore.dao.impl.ProductDAOImpl;
import com.petstore.domain.Category;
import com.petstore.domain.Item;
import com.petstore.domain.Product;



@Component("catalogService")
public class CatalogService {

 
  private CategoryDAO categoryMapper ;
  
  private ItemDAO itemMapper ;
 
  private ProductDAO productMapper ;

  public List<Category> getCategoryList() {
    return categoryMapper.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryMapper.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
    return productMapper.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productMapper.getProductListByCategory(categoryId);
  }

  // TODO enable using more than one keyword
  public List<Product> searchProductList(String keyword) {
    return productMapper.searchProductList("%" + keyword.toUpperCase() + "%");
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemMapper.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {
    return itemMapper.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
    return itemMapper.getItem(itemId).getQuantity() > 0;
  }
  
  public List<String> getCategoryNameByWords(String word){
	  return categoryMapper.getCategoryNameByWords("%"+word.toUpperCase()+"%");
  }

  @Resource(name="categoryDAO")
public void setCategoryMapper(CategoryDAO categoryMapper) {
	this.categoryMapper = categoryMapper;
}
  @Resource(name="itemDAO")
public void setItemMapper(ItemDAO itemMapper) {
	this.itemMapper = itemMapper;
}
  @Resource(name="productDAO")
public void setProductMapper(ProductDAO productMapper) {
	this.productMapper = productMapper;
}
}