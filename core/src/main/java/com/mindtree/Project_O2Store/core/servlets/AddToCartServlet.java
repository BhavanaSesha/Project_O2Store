
package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.Project_O2Store.core.dao.AddToCartDao;
import com.mindtree.Project_O2Store.core.entity.Cart;







@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Cart/AddToCartServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class AddToCartServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	static AddToCartDao dao = new AddToCartDao();
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		
		String action = request.getParameter("action");
		String custId = request.getParameter("customerId");
		if(action.equals("fetchdata"))
		{
			PrintWriter out = response.getWriter();
			 dao.fetchDetails(custId);
			//ObjectMapper mapper = new ObjectMapper();
			//String cartJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cart);
			//out.println(cartJson);
		}
			
	}
}