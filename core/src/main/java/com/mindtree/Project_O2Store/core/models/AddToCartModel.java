package com.mindtree.Project_O2Store.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.dao.AddToCartDao;
import com.mindtree.Project_O2Store.core.entity.Cart;


@Model(adaptables = Resource.class)
public class AddToCartModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	List<Cart> cart = new ArrayList<Cart>();

	AddToCartDao dao = new AddToCartDao();
	int total = 0;

	@PostConstruct
	public void display() {
		logger.info("inside add to cart model");
		cart = dao.fetchDetails();
		logger.info("product details are "+cart);
		for (int i = 0; i < cart.size(); i++) {
			total = total + (cart.get(i).getPrice() * cart.get(i).getCount());
		}
		logger.info("total is " + total);
	}

	public List<Cart> getDetails() {

		return cart;
	}
	
	public int getTotal() {
		return total;
	}

}
