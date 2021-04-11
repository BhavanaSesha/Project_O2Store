package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.dao.AddToCartDao;




@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Cart/CookieServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class CookieServlet extends SlingAllMethodsServlet {
	
	private AddToCartDao dao;

	public void init() {
		dao = new AddToCartDao();
	}
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(getClass());


	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
		logger.info("i'm in cookie servlet");
		String custId = request.getParameter("customerId");
		logger.info("This is Cookie Value" +custId);
		dao.setCookie(custId);
		}
			
	}


