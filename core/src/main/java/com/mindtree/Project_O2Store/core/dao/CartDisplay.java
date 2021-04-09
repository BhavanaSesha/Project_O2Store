package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.entity.Cart;



public class CartDisplay {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public List<Cart> getData() {
		logger.info("In product card dao impl class");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		DBUtil connection = new DBUtil();

		List<Cart> detail = new ArrayList<Cart>();
		int plant_id;
		String plant_display_name;
		int quantity;
		int price;

		try {
			con = connection.getConnection();
			String query = "select * from cart";
			statement = con.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				logger.info("In resultset");
				plant_id = resultSet.getInt("plant_id");
				plant_display_name = resultSet.getString("plant_display_name");
				logger.info(plant_display_name);
				quantity = resultSet.getInt("quantity");
				price = resultSet.getInt("price");

				detail.add(new Cart(plant_id, plant_display_name, quantity, price));

				logger.info("detail ", detail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		logger.info("End of dao");
		return detail;

	}
	
	 public int getSum() {
	        int sum = 0;
	        Connection con = null;
	        PreparedStatement statement1 = null;
	        ResultSet resultSet1 = null;
	        DBUtil connection = new DBUtil();
	        con = connection.getConnection();
	        String query1 = "select SUM(price) as total from cart";
	        try {
	            statement1 = con.prepareStatement(query1);
	        } catch (SQLException e1) {            
	            e1.printStackTrace();
	        }
	        try {
	            resultSet1 = statement1.executeQuery();
	        } catch (SQLException e1) {        
	            e1.printStackTrace();
	        }
	        try {
	            while (resultSet1.next()) {
	                sum = resultSet1.getInt("total");
	                logger.info(""+sum);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return sum;
	        
	    }
}