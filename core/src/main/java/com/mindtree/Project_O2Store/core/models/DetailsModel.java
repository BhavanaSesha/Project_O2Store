package com.mindtree.Project_O2Store.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.mindtree.Project_O2Store.core.dao.CartDisplay;
import com.mindtree.Project_O2Store.core.entity.Cart;



@Model(adaptables = Resource.class)
public class DetailsModel {
	List<Cart> cards = new ArrayList<Cart>();

	CartDisplay dao = new CartDisplay();

	int total;
	
	@PostConstruct
	public void display() {

		cards = dao.getData();
		total = dao.getSum();
	}

	public List<Cart> getDetails() {

		return cards;
	}
	
	public int getTotal() {
		return total;
		}
}