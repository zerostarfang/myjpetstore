package com.petstore.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.petstore.domain.Category;
import com.petstore.domain.Item;
import com.petstore.domain.Product;
import com.petstore.service.CatalogService;
/**
 * 这个action是处理所有web-inf/jsp/catalog下所有的jsp的   也就是catalog模块的
 * @author shishi
 *
 */
@Scope("prototype")
public class CatalogAction extends ActionSupport{
	private String name; //由Main.jsp传过来的参数  作为关键字查询category
	private String categoryId;//由category.jsp传过来的参数  作为关键字查询product
	private String productId;//.....
	private String itemId;
	private String keyword;
	
	
	List<Product> products=new ArrayList<Product>();
	 Category category=null;
	CatalogService service ;
	
	Product product=new Product();
	List<Item> itemList=new ArrayList<Item>();
	
	Item item=new Item();
	
	
	List<Product> productList=new ArrayList<Product>();
	/**
	 * 用处是作为Main.jsp中鼠标放在图片上显示提示的
	 * @return null
	 */
	public String showTip()
	{
	    System.out.println(name);
	    Category category=service.getCategory(name);
	    String res="";
	    res= "<name>"+category.getName()+"</name>";
	    HttpServletResponse resp= ServletActionContext.getResponse();
		 resp.setContentType("text/XML;charset=UTF-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println("<response>");
			out.println(res);
			out.println("</response>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	/**
	 * 次方法的作用是跳转到Category.jsp页面的
	 * @return ok
	 */
	public String toCategory()
	{
		
		   category=service.getCategory(categoryId);
		   products=service.getProductListByCategory(categoryId);
		   
		   HttpSession session=ServletActionContext.getRequest().getSession();
		   session.setAttribute("category", category);
		   session.setAttribute("productList", products);
		   
	   return "ok";
	}
	
	
	/**
	 * 次方法的作用是跳转到Product.jsp页面的
	 * @return ok
	 */
	
	public String toProduct()
	{
		
		product=service.getProduct(productId);
		itemList=service.getItemListByProduct(productId);

		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("product", product);
		session.setAttribute("itemList", itemList);
		   
	   return "ok";
	}
	
	/**
	 * 次方法的作用是跳转到Item.jsp页面的
	 * @return ok
	 */
	
	public String toItem()
	{
		
	    item=service.getItem(itemId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("item", item);
		   
	   return "ok";
	}
	
	
	public String search()
	{
		
       productList=service.searchProductList(keyword); 
       HttpSession session=ServletActionContext.getRequest().getSession();
	   session.setAttribute("productList", productList); 
	   return "ok";
	}
  
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	
	 


	@Resource(name="catalogService")
	public void setService(CatalogService service) {
		this.service = service;
	}




}
