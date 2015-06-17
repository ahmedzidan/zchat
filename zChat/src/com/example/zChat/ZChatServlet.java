package com.example.zChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class ZChatServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String FName=req.getParameter("First Name");
		String LName=req.getParameter("Last Name");
		String UName=req.getParameter("user Name");
		String Email=req.getParameter("Email");
		String Password=req.getParameter("Password");
		String conPass=req.getParameter("confirmatoin Password");
		String gender=req.getParameter("gender");
		String message="";
		RequestDispatcher rd = null;
		Query q=new Query("users");
		q.setFilter(new  Query.FilterPredicate("UserName",
                		 Query.FilterOperator.EQUAL, UName)
                		 );
		DatastoreService ds= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq=ds.prepare(q);
		String mail = "";
		String username="";
		for (Entity result : pq.asIterable()) { 
			username=(String) result.getProperty("UserName");
			 //System.out.println(pass+ " " + mail); 
		}
		
		
		 String upperCaseChars = "(.*[A-Z].*)";
		 String lowerCaseChars = "(.*[a-z].*)";
		 String numbers = "(.*[0-9].*)";
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if ( FName==""||LName==""||UName==""||Email==""||Password==""||Password==""||conPass==""||gender=="" )
		{
			
			//message="cann't be empty</br>";
			//out.println(message);
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('this field cannot be empty');");
			   out.println("location='signup.html';");
			   out.println("</script>");

			
		}
//========================================================		
		else if(!FName.matches("[a-zA-Z]+"))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('First name must be string');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!LName.matches("[a-zA-Z]+"))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('last name must be string');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!UName.matches("[a-zA-Z]+"))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('user name must be string');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if ( !conPass.equals(Password) )
			{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('password doesnot match');");
			   out.println("location='signup.html';");
			   out.println("</script>");
			}
//========================================================================
		else if ( Password.length() < 10)
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('password must be at least 10char');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!Password.matches(upperCaseChars ))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('password must include at lest one uppercase char');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!Password.matches(lowerCaseChars ))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('password must include at least one lowercase char');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!Password.matches(numbers ))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('password must include at least one number');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(!Email.matches(EMAIL_REGEX))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Email not vaild');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else if(username.equals(UName))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('user name is exist');");
			   out.println("location='signup.html';");
			   out.println("</script>");
		}
		else
		{

			Cookie userName = new Cookie("userName",UName);
			resp.addCookie(userName);
			Entity e=new Entity("users");
			e.setProperty("UserName",UName);
			e.setProperty("FirstName",FName);
			e.setProperty("LastName",LName);
			e.setProperty("Email",Email);
			e.setProperty("password",Password);
			e.setProperty("sex",gender);
			e.setProperty("isAdmin","false");
			DatastoreService ds2= DatastoreServiceFactory.getDatastoreService(); 
			ds2.put(e);
			resp.sendRedirect("sendmail");
			//resp.sendRedirect("hUser.html");
            //go to home html                                
			
	/*		message="hello "+UName+"<br>";
			message+="your Data is<br>";
			message+="first Name"+FName+"<br>";
			message+="last Name"+LName+"<br>";
			message+="user Name"+UName+"<br>";
			message+="password"+Password+"<br>";
			message+="gender"+gender+"<br>";
			out.println("<html>\n"+"<body>\n"+"<h1 align=\"center\">"+message+"</h1>\n"+"</body></html>");	
	*/
		}     		
		//resp.getWriter().println("My name is ahmed mahmoud mahmed ahmed zidan");
		//resp.getWriter().println("ID:20110093");
	}
}