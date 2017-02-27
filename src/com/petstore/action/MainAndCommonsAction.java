package com.petstore.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.petstore.service.CatalogService;
@Scope("prototype")
public class MainAndCommonsAction extends ActionSupport{
	
	private String name;
	
	private CatalogService service ;
	
	
	public String main()
	{
		return "ok";
	}
	
	/**
	 * 用于搜索中的自动完成
	 * @return null
	 * @throws IOException 
	 */
	public String autoComplete() 
	{
	
		
		List matching = service.getCategoryNameByWords(name);
		HttpServletResponse response=ServletActionContext.getResponse();
		if (matching.size() > 0) {
		PrintWriter out;
		try {
			out = response.getWriter();
			response.setContentType("text/XML;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			out.println("<response>");
			Iterator iter = matching.iterator();
			while(iter.hasNext()) {
			String name1 = (String) iter.next();
			out.println("<name>" + name1 + "</name>");
			}
			out.println("</response>");
			matching = null;
			service = null;
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} else {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Resource( name="catalogService")
	public void setService(CatalogService service) {
		this.service = service;
	}
	

}
