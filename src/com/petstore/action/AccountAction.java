package com.petstore.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.petstore.domain.Account;
import com.petstore.domain.Product;
import com.petstore.service.AccountService;
import com.petstore.service.CatalogService;
/**
 * 这个action是处理所有web-inf/jsp/account下所有的jsp的   也就是account模块的
 * @author shishi
 *
 */
@Scope("prototype")
public class AccountAction extends ActionSupport{
	private String username;
	private String password;
	private String yanzheng;
	private AccountService service ;
	
	private Boolean authenticated=false;
    private Account account;
    private Account account1;
	private List<Product> myList=new ArrayList<Product>();
	private CatalogService catalogService  ;
	private String error=null;
	private String repeatedPassword;
	private String name;
	
	private Date birthday;///测试类型转化器的
	
	private ByteArrayInputStream inputStream;  

	HttpSession session=ServletActionContext.getRequest().getSession();
	HttpServletRequest request=ServletActionContext.getRequest();
	public  String rand() throws Exception
	{
//      在内存中创建图象  
        int width=85, height=20;  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
//       获取图形上下文  
        Graphics g = image.getGraphics();  
//      生成随机类  
        Random random = new Random();  
//       设定背景色  
        g.setColor(getRandColor(200,250));  
        g.fillRect(0, 0, width, height);  
//      设定字体  
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));  
//       随机产生155条干扰线，使图象中的认证码不易被其它程序探测到  
        g.setColor(getRandColor(160,200));  
        for (int i=0;i<155;i++)  
        {  
         int x = random.nextInt(width);  
         int y = random.nextInt(height);  
                int xl = random.nextInt(12);  
                int yl = random.nextInt(12);  
         g.drawLine(x,y,x+xl,y+yl);  
        }  
//       取随机产生的认证码(6位数字)  
        String sRand="";  
        for (int i=0;i<6;i++){  
            String rand=String.valueOf(random.nextInt(10));  
            sRand+=rand;  
            // 将认证码显示到图象中  
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));  
//      调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成  
            g.drawString(rand,13*i+6,16);  
        }  
//       将认证码存入SESSION  
        ActionContext.getContext().getSession().put("rand",sRand);  
//       图象生效  
        g.dispose();  
        ByteArrayOutputStream output = new ByteArrayOutputStream();  
        ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);  
        ImageIO.write(image, "JPEG", imageOut);  
        imageOut.close();  
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());  
        this.setInputStream(input);  
        return SUCCESS;  

	}
	
	 /*  
     * 给定范围获得随机颜色  
     */  
    private Color getRandColor(int fc,int bc){  
        Random random = new Random();  
        if(fc>255) fc=255;  
        if(bc>255) bc=255;  
        int r=fc+random.nextInt(bc-fc);  
        int g=fc+random.nextInt(bc-fc);  
        int b=fc+random.nextInt(bc-fc);  
        return new Color(r,g,b);  
   }  
    public void setInputStream(ByteArrayInputStream inputStream) {  
        this.inputStream = inputStream;  
    }  
    public ByteArrayInputStream getInputStream() {  
        return inputStream;  
    }  

	
	/**
	 * 跳转登陆界面SignonForm.jsp
	 * @return ok
	 */
	
	public  String toSignonForm()
	{
		//HttpSession session=ServletActionContext.getRequest().getSession();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		//System.out.println(session.getAttribute("toCarError"));
		request.setAttribute("toCarError", session.getAttribute("toCarError"));
		session.setAttribute("toCarError", "");
		return "ok";
	}
	
	/**
	 * 用于登陆
	 * @return  loginFail或者loginSuccess
	 */
	public String login()
	{
		account1=new Account();	
		if(service.getAccount(username, password)==0 || !yanzheng.trim().equals(session.getAttribute("rand")))
		{
			authenticated=false;
			error="Login failed";
			session.setAttribute("authenticated",authenticated);
		   request.setAttribute("error", error);
			return "loginFail";
		}
		else{
			account1=service.getAccount(username);
			myList = catalogService.getProductListByCategory(account1.getFavouriteCategoryId());
			authenticated=true;
			//error="";
			session.setAttribute("accountBean", account1);
			session.setAttribute("authenticated",authenticated);
			//session.setAttribute("error", error);
			session.setAttribute("MyList", myList);
			
			return "loginSuccess";
			
		}
		
		
	}
	
	/**
	 * 跳转注册界面NewAccountForm.jsp
	 * @return ok
	 */
	
	public  String toRegister()
	{
		return "ok";
	}
	/**
	 * 注册     成功后跳到SignonForm.jsp
	 * @return ok
	 */
	
	public  String register()
	{
	  
		service.insertAccount(account);
		System.out.println("aaaaaaaaaaa"+birthday);
		return "ok";
	}

	
	
	/**
	 * 跳转注册界面EditAccountForm.jsp
	 * @return ok
	 */
	
	public  String toEditAccount()
	{
		
		return "ok";
	}
	
	
	/**
	 * 修改账户
	 * @return ok
	 */
	
	public  String editAccount()
	{
		System.out.println( "sssssssssssssss"+account.getPassword());
        service.updateAccount(account);
		//HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("accountBean", null);
		session.setAttribute("authenticated", false);
		session.setAttribute("error", null);
		return "ok";
	}
	
	/**
	 * 判断用户名是否存在
	 * @return null
	 */
	
	public  String userExist()
	{
		//AccountService service=new AccountService();
	    // String name=req.getParameter("name");
	     String res;
	     System.out.print(service.getAccount(name));
	     HttpServletResponse resp=ServletActionContext.getResponse();
	     if(service.getAccount1(name)==1)
	     {
	    	 System.out.print("aaa");
	    	 	
	    	 res= "<percent>"+"0"+"</percent>";
	    	 resp.setContentType("text/XML;charset=UTF-8");
	     }
	     else {
	    	 System.out.print("bbb");
	    	 res= "<percent>"+"1"+"</percent>";
	    	 resp.setContentType("text/XML;charset=UTF-8");
	     }
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
	 * 修改账户
	 * @return ok
	 */
	
	public  String loginOut()
	{
        
		
		session.setAttribute("authenticated", false);
		session.setAttribute("error", null);
		session.setAttribute("accountBean", null);
		session.setAttribute("MyList", null);
		return "ok";
	}
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setAccount(Account account) {   //用此方式接受表单传上来的值
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

 

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getYanzheng() {
		return yanzheng;
	}

	public void setYanzheng(String yanzheng) {
		this.yanzheng = yanzheng;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	@Resource(name="accountService")
	public void setService(AccountService service) {
		this.service = service;
	}

	@Resource(name="catalogService")
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	
	
	

}
