package com.example.zChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
public class login extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String Email=req.getParameter("Email");
		String Password=req.getParameter("Password");
		Query q=new Query("users");
		q.setFilter(new Query.CompositeFilter(
                 Query.CompositeFilterOperator.AND,new ArrayList<Query.Filter>(Arrays.asList
                		 (new Query.FilterPredicate("Email",
                		 Query.FilterOperator.EQUAL, Email)
                		 ,new Query.FilterPredicate("password",
                        		 Query.FilterOperator.EQUAL, Password)
                		 
                				 ))));
		DatastoreService ds= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq=ds.prepare(q);
		String mail = "";
		String pass = "";
		String username="";
		for (Entity result : pq.asIterable()) { 
			 mail=(String) result.getProperty("Email");
			 pass=(String) result.getProperty("password");
			username=(String) result.getProperty("UserName");
			 //System.out.println(pass+ " " + mail); 
		} 
		//}
		//out.print(mail);
		//out.println(pass);
		if(mail!="" && pass!="")
		{
			Cookie userName = new Cookie("userName",username);
			//Cookie email = new Cookie("Email",mail);
			resp.addCookie(userName);
			//resp.addCookie(email);
			//HttpSession session = req.getSession(true);
			//session.setAttribute("username", username);
			Query q2=new Query("users");
			q2.setFilter(new Query.CompositeFilter(
	                 Query.CompositeFilterOperator.AND,new ArrayList<Query.Filter>(Arrays.asList
	                		 (new Query.FilterPredicate("Email",
	                		 Query.FilterOperator.EQUAL, Email)
	                		 ,new Query.FilterPredicate("password",
	                        		 Query.FilterOperator.EQUAL, Password)
	                		 ,new Query.FilterPredicate("isAdmin",
	                        		 Query.FilterOperator.EQUAL,"true")
	                				 ))));
			DatastoreService ds2= DatastoreServiceFactory.getDatastoreService();
			PreparedQuery pq2=ds2.prepare(q2);
			String isadmin="";
			for (Entity result : pq.asIterable()) { 
				isadmin=(String) result.getProperty("isAdmin");
				 
			} 
			if(isadmin.equals("true"))
			{
				resp.sendRedirect("hAdmin.html");
			}
			else
			{
				resp.sendRedirect("hUser.html");	
			}
			
		}
		else
		{
			//resp.sendRedirect("home.html");
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('mail or password incorrect');");
			   out.println("location='index.html';");
			   out.println("</script>");
			
			//resp.sendRedirect("login.html");
			//out.println("<html><body onload=\"alert('mail or password not correct')\"></body></html>");
		}
		//out.println(Email);
		//out.println(Password);
	}
	
}