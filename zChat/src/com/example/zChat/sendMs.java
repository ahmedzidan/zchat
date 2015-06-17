package com.example.zChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class sendMs extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String content=req.getParameter("content");
		Cookie ck[]=req.getCookies();
		Date date = new Date();
		SimpleDateFormat ft = 
	    new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss ");
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	     String[] noticesChecked = req.getParameterValues("selected");
	     for (int i=0; i<noticesChecked.length; i++) {
	         String noticeKey = noticesChecked[i];
	         Entity e=new Entity("privateMs");
				e.setProperty("to",noticeKey);
				e.setProperty("from",ck[0].getValue());
				e.setProperty("content",content);
				e.setProperty("Date",ft.format(date));
				datastore.put(e);
	     }
		
	     resp.sendRedirect("privateChat");
	}
}