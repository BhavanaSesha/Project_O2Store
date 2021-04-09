package com.mindtree.Project_O2Store.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.dao.QuickBuyDao;
import com.mindtree.Project_O2Store.core.entity.Plants;



@Model(adaptables = Resource.class)
public class QuickPayModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	Plants cards = new Plants();
int price;
String name;
int id;
	QuickBuyDao dao = new QuickBuyDao();

	@PostConstruct
	protected void init() {
		logger.info("entered postconstruct");
		logger.info("hello world 6 march quickbuy");
		cards = dao.getData();
		logger.info(""+cards.getPrice());
		price=cards.getPrice();
		id=cards.getPlantId();
		name=cards.getPlantDisplayName();
	}

	public int getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	

}

