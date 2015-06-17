package com.example.zChat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class deleteM extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	     DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	     String[] noticesChecked = req.getParameterValues("selected");

	     for (int i=0; i<noticesChecked.length; i++) {
	         Key noticeKey = KeyFactory.stringToKey(noticesChecked[i]);
	         datastore.delete(noticeKey);
	     }
	     resp.sendRedirect("Mcontrol");
}
}