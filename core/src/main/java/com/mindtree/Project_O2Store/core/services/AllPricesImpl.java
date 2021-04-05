package com.mindtree.Project_O2Store.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.mindtree.Project_O2Store.core.dao.AllPricesDao;
import com.mindtree.Project_O2Store.core.entity.Product;


@Component(service = AllPrices.class, immediate = true)
public class AllPricesImpl implements AllPrices{

	List<Product> range1Plants = new ArrayList<>();
	List<Product> range2Plants = new ArrayList<>();
	List<Product> range3Plants = new ArrayList<>();

	@Activate
	@Modified
	public void activate() {
	 range1Plants = new AllPricesDao().fetchRange1PlantsData();
	 range2Plants = new AllPricesDao().fetchRange2PlantsData();
	 range3Plants = new AllPricesDao().fetchRange3PlantsData();
	}

	@Override
	public List<Product> readRange1Data() {
		// TODO Auto-generated method stub
		return range1Plants;
	}

	@Override
	public List<Product> readRange2Data() {
		// TODO Auto-generated method stub
		return range2Plants;
	}

	@Override
	public List<Product> readRange3Data() {
		// TODO Auto-generated method stub
		return range3Plants;
	}
	
	
}
