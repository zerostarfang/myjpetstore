package com.petstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginOrNotInterceptor implements Interceptor{



	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 HttpSession session=ServletActionContext.getRequest().getSession();
		 HttpServletRequest  request=ServletActionContext.getRequest();
		 if( session.getAttribute("accountBean")==null)
		 {
			  ActionSupport action=(ActionSupport)invocation.getAction();
			 // action.addActionError("请先登录");
			 session.setAttribute("toCarError","please login before checking shopping car");
			  return Action.LOGIN;
		 }
		 else
			 return invocation.invoke();
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
