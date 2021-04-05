package com.mindtree.Project_O2Store.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mindtree.Project_O2Store.core.entity.Product;
import com.mindtree.Project_O2Store.core.services.AllPrices;



@Model(adaptables = Resource.class)
public class AllPricesModel {
	
	@OSGiService
	private AllPrices allPrices;
	
	List<Product> range1Plants;
	List<Product> range2Plants;
	List<Product> range3Plants;
	
	@PostConstruct
	protected void init() {
		range1Plants= allPrices.readRange1Data();
		range2Plants= allPrices.readRange2Data();
		range3Plants= allPrices.readRange3Data();
	}

	public List<Product> getRange1Plants() {
		return range1Plants;
	}

	public List<Product> getRange2Plants() {
		return range2Plants;
	}

	public List<Product> getRange3Plants() {
		return range3Plants;
	}
	
	
	

}
