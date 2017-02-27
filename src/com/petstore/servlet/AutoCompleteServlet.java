package com.petstore.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import com.petstore.service.CatalogService;
public class AutoCompleteServlet extends HttpServlet {
private List names = new ArrayList();

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String prefix = request.getParameter("names");

CatalogService service = new CatalogService();
List matching = service.getCategoryNameByWords(prefix);
if (matching.size() > 0) {
PrintWriter out = response.getWriter();
response.setContentType("text/xml");
response.setHeader("Cache-Control", "no-cache");
out.println("<response>");
Iterator iter = matching.iterator();
while(iter.hasNext()) {
String name = (String) iter.next();
out.println("<name>" + name + "</name>");
}
out.println("</response>");
matching = null;
service = null;
out.close();
} else {
response.setStatus(HttpServletResponse.SC_NO_CONTENT);
}
}
}