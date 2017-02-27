package com.petstore.domain;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class Product implements Serializable {

  private static final long serialVersionUID = -7492639752670189553L;
  private String productId;

  private String name;
  private String description;
  private Category category;
  private Set items=new HashSet<Item>();

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId.trim();
  }

  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String toString() {
    return getName();
  }

public Category getCategory() {
	return category;
}
@PersistenceContext(type=PersistenceContextType.EXTENDED)
public void setCategory(Category category) {
	this.category = category;
}

public Set getItems() {
	return items;
}

public void setItems(Set items) {
	this.items = items;
}

}
