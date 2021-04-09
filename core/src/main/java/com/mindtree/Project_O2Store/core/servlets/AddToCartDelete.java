package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.AddToCartDeleteDao;



@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Cart/CartDelete",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class AddToCartDelete extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	static AddToCartDeleteDao dao = new AddToCartDeleteDao();
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
        String customer_id1 = request.getParameter("customerId");
		
		try {
			dao.removeAllData(customer_id1);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}

