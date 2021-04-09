package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.QuickShopDeleteDao;



@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Quick/QuickShopDelete",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class Quickshopdelete extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	static QuickShopDeleteDao dao = new QuickShopDeleteDao();
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			dao.removeAllData(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}



