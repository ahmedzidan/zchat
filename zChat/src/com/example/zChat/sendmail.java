package com.example.zChat;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
public class sendmail extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Properties props = new Properties();
		 Session session = Session.getDefaultInstance(props, null);

		 String msgBody = "welcome in zchat interest with your chat!we hope you like it :) ";
		 Cookie ck[]=req.getCookies();
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Query q= new Query("users");
			
			q.setFilter(
	                new Query.FilterPredicate("UserName",
	               		 Query.FilterOperator.EQUAL, ck[0].getValue())
	               		 		 );
			PreparedQuery pq = datastore.prepare(q);
			String email="";
			for (Entity result : pq.asIterable()) { 
				 email=(String) result.getProperty("Email");
			}
		 try {
		 Message msg = new MimeMessage(session);
		 msg.setFrom(new InternetAddress("ahmedzidan.2015@gmail.com", "zidanco.com Admin"));
		 msg.addRecipient(Message.RecipientType.TO,
		new InternetAddress(email, ck[0].getValue()));
		msg.setSubject("zidanco chat confirmation mail");
		msg.setText(msgBody);
		Transport.send(msg);

		} catch (AddressException e) {
		 // ...
			e.printStackTrace();
		 } catch (MessagingException e)
		 {
	          // ...
		      e.printStackTrace();
	     }
		 resp.sendRedirect("hUser.html");
	}
}