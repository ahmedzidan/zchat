package com.example.zChat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Mcontrol extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PrintWriter out=resp.getWriter();
		Cookie ck[]=req.getCookies();
		String uname=ck[0].getValue();
		out.println("<html>");
		out.println("<head>");
		out.println("<script src='js/jquery.min.js'></script>");
		out.println("<link href='css/style.css' rel='stylesheet' type='text/css' media='all' />");
		out.println("<script src='js/wow.min.js'></script>");
		out.println("<link rel='stylesheet' href='css/flexslider.css' type='text/css' media='screen' />");
		out.println("<link href='css/animate.css' rel='stylesheet' type='text/css' />");
		out.println("<link href='css/animate.css' rel='stylesheet' type='text/css' />");
		out.println("<script>");
		out.println("new WOW().init();");
		out.println("</script>");
		out.println("<body>");
		
		out.println("<div class='header' id='home'>");
		out.println("<div class='container'>");
		out.println("<div class='logo wow fadeInRight' data-wow-delay='0.4s'>");
		out.println("<h2> welcome "+uname+"</h2>");
		out.println("</div>");
		out.println("<span class='menu'></span>");
		out.println("<div class='top-menu wow fadeInLeft' data-wow-delay='0.4s'>");
		out.println("<ul>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='publicChat'>public chat</a></li>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='privateChat'>private chat</a></li>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='inbox'>inbox</a></li>");
		out.println("<li><a class='active scroll hvr-shutter-out-horizontal' href='Mcontrol'>review comments</a></li>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='ucontrol'>user control </a></li>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='makeadmin'>Make Admin</a></li>");
		out.println("<li><a class='scroll hvr-shutter-out-horizontal' href='logout'>logout</a></li>");
		out.println("</ul>");
		out.println("</div>");
				
		out.println("<script>");
		out.println("$( 'span.menu' ).click(function() {");
		out.println("$( '.top-menu' ).slideToggle( 'slow', function() {");
				    // Animation complete.
		out.println("});");
		out.println("});");
		out.println("</script>");
		out.println("<div class='clearfix'></div>");
		out.println("</div>");
		out.println("</div>");
//=========================================================================================================		
		out.println("<div class='banner wow fadeInUp' data-wow-delay='0.4s'>");
		out.println("<div class='container'>");
		out.println("<div class='banner-info text-center'>");
		out.println("<div class='details wow fadeInLeft' data-wow-delay='0.4s'>");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		out.println("<form  action='deleteM' method='get'>");
		Query query = new Query("publicMs");
		query.addSort("Date");
		PreparedQuery pq = datastore.prepare(query);
		out.println("<table class='table table-hover table-striped'>");
		for (Entity result : pq.asIterable()) { 
			String content=(String) result.getProperty("content");
			String username=(String) result.getProperty("name");
			out.println("<tr>");
			out.println("<td >");out.println(username);out.println("</td>");
			out.println("<td >");out.println(content);out.println("</td>");
			out.println("<td >");
			out.print("<input type='checkbox' name='selected' value="+KeyFactory.keyToString(result.getKey())+">");
			out.println("</td >");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println(" <input type='submit' value='Delete!'>");
		out.println("</form>");
		out.println("</div>");
				out.println("</div>");
				
				out.println("</div>");
				
				out.println("</div>");
				
				out.println("<body>");
				out.println("</html>");			
	}
}
