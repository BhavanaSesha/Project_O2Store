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



public class AddToCartDao {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public List<Cart> fetchDetails() {
		logger.info("In display cart dao impl class");
		List<Cart> carts = new ArrayList<>();
		String query = "select cart.plant_id,cart.plant_display_name,cart.price,cart.quantity from cart inner join cart_customer on cart.cart_id = cart_customer.cart_id inner join cookie on cart_customer.customer_id = cookie.customer_id;";
		Connection connection;
		PreparedStatement statement;
		ResultSet resultset;
		connection = DBUtil.getConnection();
		try {
			statement = connection.prepareStatement(query);
			logger.info("statement", statement);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Cart cart = new Cart();
				cart.setId(resultset.getInt(1));
				cart.setName(resultset.getString(2));
				cart.setPrice(resultset.getInt(3));
				cart.setCount(resultset.getInt(4));
				carts.add(cart);
				logger.info("carts", carts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("error in dao add to cart");
		}
		return carts;
	}

	public int setCookie(String custId) {
		Connection connection;
		PreparedStatement statement1;
		PreparedStatement statement;
		logger.info("in cookie dao");
		connection = DBUtil.getConnection();
		String query1 = "delete from cookie";
		String query = "insert into cookie values (?)";
		int i = 0;
		int j = 0;
		try {
			statement1 = connection.prepareStatement(query1);
			statement = connection.prepareStatement(query);
			statement.setString(1, custId);
			j = statement1.executeUpdate();
			i = statement.executeUpdate();
			if(i!=0 && j!=0) {
				logger.info("added to database");
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 1;

	}
}