package com.mindtree.Project_O2Store.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.mindtree.Project_O2Store.core.dao.QuickShopDao;


@Component(service = Servlet.class, property = { "sling.servlet.paths=" + "/bin/Quickshop/QuickshopServlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class QuickShop extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	private QuickShopDao quickShopDao;

	public void init() {
		quickShopDao = new QuickShopDao();
	}

	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));


		try {
			quickShopDao.quickShopDetails(id,name,price);
		} catch (Exception e) {
			e.printStackTrace();
		}}}

