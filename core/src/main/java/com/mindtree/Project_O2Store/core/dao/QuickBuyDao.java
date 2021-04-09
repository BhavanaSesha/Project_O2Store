package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.Project_O2Store.core.entity.Plants;



public class QuickBuyDao  {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	public Plants getData() {
		logger.info("In product quickshop dao impl class");

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		DBUtil connection = new DBUtil();

		Plants detail = null;
		int id;
		String name;
		int price;

		try {
			con = connection.getConnection();
			String query = "select * from quickshop";
			statement = con.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				logger.info("In resultset");
				id = resultSet.getInt("id1");
				logger.info(""+id);
				name = resultSet.getString("name");
				logger.info(name);
				price = resultSet.getInt("price");
				logger.info(""+price);
				detail = new Plants(id,name,price);
			}
			
           
		} catch (SQLException e) {

			e.printStackTrace();
		}
		logger.info("End of dao");
		return detail;

	}
	

}


