package com.mindtree.Project_O2Store.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.dao.AddToCartDao;
import com.mindtree.Project_O2Store.core.dao.CartDisplay;
import com.mindtree.Project_O2Store.core.entity.Cart;



@Model(adaptables = Resource.class)
public class DetailsModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	List<Cart> cards = new ArrayList<Cart>();

	//CartDisplay dao = new CartDisplay();
	AddToCartDao cartobj;
	
	int total;
	
	@PostConstruct
	public void display() {

		//cards = dao.getData();
		//total = dao.getSum();
		logger.info("From model to check list above the method");
		cards = cartobj.getCarts();
		logger.info("From model to check list");
	}

	public List<Cart> getDetails() {

		return cards;
	}
	
	public int getTotal() {
		return total;
		}
}