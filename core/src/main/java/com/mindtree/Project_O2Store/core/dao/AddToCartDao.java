package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Project_O2Store.core.entity.Cart;



public class AddToCartDao {
	List<Cart> carts = new ArrayList<>();
	//static  List<Cart> carts = new ArrayList<>();
	public void fetchDetails(String custId){
		  // List<Cart> carts = new ArrayList<>();
		   String query = "select cart.plant_id,cart.plant_display_name,cart.price,cart.quantity from cart inner join cart_customer on cart.cart_id = cart_customer.cart_id where customer_id = ?";
		   Connection connection;
		   PreparedStatement statement;
		   ResultSet resultset;
		   connection = DBUtil.getConnection();
		   try {
			statement = connection.prepareStatement(query);
			statement.setString(1, custId);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				Cart cart = new Cart();
				cart.setId(resultset.getInt(1));
				cart.setName(resultset.getString(2));
				cart.setPrice(resultset.getInt(3));
				cart.setCount(resultset.getInt(4));
				carts.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	public List<Cart> getCarts() {
		return carts;
	}


}
