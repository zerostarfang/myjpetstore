package com.petstore.commons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	private String requestEncode = "UTF-8";
	private String responseEncode = "text/html;charset=UTF-8";

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		request.setCharacterEncoding(requestEncode);

		response.setContentType(responseEncode);

		
		

		if("GET".equals(request.getMethod().toUpperCase())){
			Iterator<String[]> iter=request.getParameterMap().values().iterator();
		      while(iter.hasNext()){
			       String[] parames=iter.next();
			       for (int i = 0; i < parames.length; i++) {
				       try {
				        	parames[i]=new String(parames[i].getBytes("iso8859-1"),request.getCharacterEncoding());
				       } catch (UnsupportedEncodingException e) {
				         e.printStackTrace();
				       }
			       } 
		      }
		}
		
		arg2.doFilter(arg0, arg1);

	}

	
	public void init(FilterConfig arg0) throws ServletException {
		requestEncode = arg0.getInitParameter("requestEncode");
		responseEncode = arg0.getInitParameter("responseEncode");
	}

}
