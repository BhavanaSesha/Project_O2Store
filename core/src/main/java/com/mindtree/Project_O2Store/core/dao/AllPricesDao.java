package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Product;

public class AllPricesDao {
/*
	public static void main(String[] args) {
		List<Product> plants = new ArrayList<>();
		plants = new AllPricesDao().fetchRange3PlantsData();
		plants.forEach(System.out::println);
	}
*/
	public List<Product> fetchRange1PlantsData() {
		List<Product> Range1Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n" + 
					"plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n" + 
					"categories on plant_categories.category_id = categories.category_id\r\n" + 
					" where  price between 300 and 700 \r\n" + 
					" and categories.category_name in ('medicine','foilage','flowers')\r\n" + 
					"order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range1Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range1Plants;

	}

	public List<Product> fetchRange2PlantsData() {
		List<Product> Range2Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql ="  select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n" + 
					"plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n" + 
					"categories on plant_categories.category_id = categories.category_id\r\n" + 
					" where  price between 701 and 1100 \r\n" + 
					" and categories.category_name in ('medicine','foilage','flowers')\r\n" + 
					"order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range2Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range2Plants;

	}

	public List<Product> fetchRange3PlantsData() {
		List<Product> Range3Plants = new ArrayList<>();
		Connection connection;
		Statement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = " select plant_name,plant_display_name,price,plants.plant_id,pdplink  from plants inner join\r\n" + 
					"plant_categories on plants.plant_id = plant_categories.plant_id inner join\r\n" + 
					"categories on plant_categories.category_id = categories.category_id\r\n" + 
					" where  price between 1101 and 1500 \r\n" + 
					" and categories.category_name in ('medicine','foilage','flowers')\r\n" + 
					"order by price;";
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				Product plant = new Product();
				plant.setProductName(resultset.getString(1));
				plant.setProductDisplayName(resultset.getString(2));
				plant.setPrice(resultset.getInt(3));
				plant.setProductId(resultset.getInt(4));
				plant.setPdpLink(resultset.getString(5));
				Range3Plants.add(plant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Range3Plants;

	}

}
