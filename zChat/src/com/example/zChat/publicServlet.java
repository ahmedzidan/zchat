package com.example.zChat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class publicServlet  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	     DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	     resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			String content=req.getParameter("content");
			
				Date date = new Date();
				SimpleDateFormat ft = 
			    new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss ");
				Cookie ck[]=req.getCookies();
				//String name= ;
				Entity e=new Entity("publicMs");
				//HttpSession session = req.getSession(true);
				//String name=(String) session.getAttribute("username");
				e.setProperty("content",content);
				e.setProperty("name",ck[0].getValue());
				e.setProperty("Date",ft.format(date));
				DatastoreService ds= DatastoreServiceFactory.getDatastoreService(); 
				ds.put(e);
				//resp.sendRedirect("/publicChat");
				//out.println(content);
				//out.println(ft.format(date));
	     resp.sendRedirect("/publicChat");
}
}